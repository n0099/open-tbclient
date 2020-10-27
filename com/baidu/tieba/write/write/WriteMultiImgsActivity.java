package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private j nFW;
    private k nIK;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.nFW = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dSt() {
                WriteMultiImgsActivity.this.nIK.dTR();
                WriteMultiImgsActivity.this.nIK.yD(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dSu() {
                WriteMultiImgsActivity.this.nIK.dTW();
                WriteMultiImgsActivity.this.nIK.yD(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean U(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.nIK.W(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dSv() {
                WriteMultiImgsActivity.this.nIK.dSv();
            }
        });
        setContentView(this.nFW.ioA);
        this.nIK = new k(getPageContext(), this.nFW, bundle);
        if (this.nIK.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.nIK.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.nIK != null && this.nIK.nIU != null) {
            bundle.putInt("OutState_Current_Index", this.nIK.nIU.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.nIK.dTU());
            bundle.putSerializable("OutState_Write_Info_Data", this.nIK.cws());
            this.nIK.nIU.yx(true);
            if (this.nIK.dTX() != null) {
                bundle.putString("OutState_Write_Img_Info", this.nIK.dTX().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dTR() {
        if (this.nIK != null) {
            this.nIK.dTR();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.nIK != null) {
            if (1 == this.nIK.dTU()) {
                ForumWriteData cws = this.nIK.cws();
                if (cws != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, cws.forumId, cws.forumName, null, null, 0, cws.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, cws.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", cws.mFrom);
                    writeActivityConfig.setCallFrom(cws.writeCallFrom);
                    writeActivityConfig.setForumLevel(cws.forumLevel);
                    writeActivityConfig.setForumAvatar(cws.avatar);
                    writeActivityConfig.setPrivateThread(cws.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    writeActivityConfig.setFrsTabInfo(cws.frsTabInfo);
                    writeActivityConfig.setProfessionZone(cws.defaultZone);
                    writeActivityConfig.setForumDir(cws.firstDir, cws.secondDir);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.nIK.dTU()) {
                Intent intent = new Intent(this, WriteActivity.class);
                intent.putExtra("KEY_WRITE_IMAGES_INFO_STRING", writeImagesInfo.toJsonString());
                intent.setFlags(536870912);
                intent.setFlags(67108864);
                startActivity(intent);
                finish();
                return;
            }
        }
        if (z) {
            if (writeImagesInfo != null) {
                Intent intent2 = new Intent();
                intent2.putExtra("album_result", writeImagesInfo.toJsonString());
                if (!y.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
                    intent2.putExtra("file_name", writeImagesInfo.getChosedFiles().get(0).extra);
                }
                setResult(-1, intent2);
            } else {
                return;
            }
        } else {
            setResult(0);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nFW != null) {
            this.nFW.Lw(i);
        }
        this.nIK.nIU.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.nIK != null) {
            this.nIK.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.nFW != null) {
            this.nFW.onDestroy();
        }
        super.onDestroy();
    }
}
