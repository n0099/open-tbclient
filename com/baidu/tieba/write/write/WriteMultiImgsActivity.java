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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes2.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h msV;
    private i mvo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.msV = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dsB() {
                WriteMultiImgsActivity.this.mvo.dtL();
                WriteMultiImgsActivity.this.mvo.vZ(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dsC() {
                WriteMultiImgsActivity.this.mvo.dtQ();
                WriteMultiImgsActivity.this.mvo.vZ(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean S(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.mvo.U(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dsD() {
                WriteMultiImgsActivity.this.mvo.dsD();
            }
        });
        setContentView(this.msV.hmU);
        this.mvo = new i(getPageContext(), this.msV, bundle);
        if (this.mvo.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.mvo.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.mvo != null && this.mvo.mvy != null) {
            bundle.putInt("OutState_Current_Index", this.mvo.mvy.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.mvo.dtO());
            bundle.putSerializable("OutState_Write_Info_Data", this.mvo.bYF());
            this.mvo.mvy.vT(true);
            if (this.mvo.dtR() != null) {
                bundle.putString("OutState_Write_Img_Info", this.mvo.dtR().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dtL() {
        if (this.mvo != null) {
            this.mvo.dtL();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mvo != null) {
            if (1 == this.mvo.dtO()) {
                ForumWriteData bYF = this.mvo.bYF();
                if (bYF != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bYF.forumId, bYF.forumName, null, null, 0, bYF.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bYF.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bYF.mFrom);
                    writeActivityConfig.setCallFrom(bYF.writeCallFrom);
                    writeActivityConfig.setForumLevel(bYF.forumLevel);
                    writeActivityConfig.setForumAvatar(bYF.avatar);
                    writeActivityConfig.setPrivateThread(bYF.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    writeActivityConfig.setFrsTabInfo(bYF.frsTabInfo);
                    writeActivityConfig.setProfessionZone(bYF.defaultZone);
                    writeActivityConfig.setForumDir(bYF.firstDir, bYF.secondDir);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.mvo.dtO()) {
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
                if (!w.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.msV != null) {
            this.msV.GY(i);
        }
        this.mvo.mvy.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mvo != null) {
            this.mvo.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.msV != null) {
            this.msV.onDestroy();
        }
        super.onDestroy();
    }
}
