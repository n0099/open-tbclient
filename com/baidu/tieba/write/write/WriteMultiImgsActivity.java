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
    private j mTN;
    private k mWw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mTN = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dHv() {
                WriteMultiImgsActivity.this.mWw.dIQ();
                WriteMultiImgsActivity.this.mWw.xu(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dHw() {
                WriteMultiImgsActivity.this.mWw.dIV();
                WriteMultiImgsActivity.this.mWw.xu(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean V(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.mWw.X(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dHx() {
                WriteMultiImgsActivity.this.mWw.dHx();
            }
        });
        setContentView(this.mTN.hFW);
        this.mWw = new k(getPageContext(), this.mTN, bundle);
        if (this.mWw.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.mWw.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.mWw != null && this.mWw.mWG != null) {
            bundle.putInt("OutState_Current_Index", this.mWw.mWG.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.mWw.dIT());
            bundle.putSerializable("OutState_Write_Info_Data", this.mWw.cmA());
            this.mWw.mWG.xo(true);
            if (this.mWw.dIW() != null) {
                bundle.putString("OutState_Write_Img_Info", this.mWw.dIW().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dIQ() {
        if (this.mWw != null) {
            this.mWw.dIQ();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mWw != null) {
            if (1 == this.mWw.dIT()) {
                ForumWriteData cmA = this.mWw.cmA();
                if (cmA != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, cmA.forumId, cmA.forumName, null, null, 0, cmA.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, cmA.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", cmA.mFrom);
                    writeActivityConfig.setCallFrom(cmA.writeCallFrom);
                    writeActivityConfig.setForumLevel(cmA.forumLevel);
                    writeActivityConfig.setForumAvatar(cmA.avatar);
                    writeActivityConfig.setPrivateThread(cmA.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    writeActivityConfig.setFrsTabInfo(cmA.frsTabInfo);
                    writeActivityConfig.setProfessionZone(cmA.defaultZone);
                    writeActivityConfig.setForumDir(cmA.firstDir, cmA.secondDir);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.mWw.dIT()) {
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
        if (this.mTN != null) {
            this.mTN.JT(i);
        }
        this.mWw.mWG.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mWw != null) {
            this.mWw.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.mTN != null) {
            this.mTN.onDestroy();
        }
        super.onDestroy();
    }
}
