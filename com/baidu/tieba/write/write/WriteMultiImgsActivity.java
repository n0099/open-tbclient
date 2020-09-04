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
    private j mUf;
    private k mWP;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mUf = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dHE() {
                WriteMultiImgsActivity.this.mWP.dIZ();
                WriteMultiImgsActivity.this.mWP.xw(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dHF() {
                WriteMultiImgsActivity.this.mWP.dJe();
                WriteMultiImgsActivity.this.mWP.xw(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean V(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.mWP.X(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dHG() {
                WriteMultiImgsActivity.this.mWP.dHG();
            }
        });
        setContentView(this.mUf.hGc);
        this.mWP = new k(getPageContext(), this.mUf, bundle);
        if (this.mWP.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.mWP.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.mWP != null && this.mWP.mWZ != null) {
            bundle.putInt("OutState_Current_Index", this.mWP.mWZ.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.mWP.dJc());
            bundle.putSerializable("OutState_Write_Info_Data", this.mWP.cmB());
            this.mWP.mWZ.xq(true);
            if (this.mWP.dJf() != null) {
                bundle.putString("OutState_Write_Img_Info", this.mWP.dJf().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dIZ() {
        if (this.mWP != null) {
            this.mWP.dIZ();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.mWP != null) {
            if (1 == this.mWP.dJc()) {
                ForumWriteData cmB = this.mWP.cmB();
                if (cmB != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, cmB.forumId, cmB.forumName, null, null, 0, cmB.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, cmB.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", cmB.mFrom);
                    writeActivityConfig.setCallFrom(cmB.writeCallFrom);
                    writeActivityConfig.setForumLevel(cmB.forumLevel);
                    writeActivityConfig.setForumAvatar(cmB.avatar);
                    writeActivityConfig.setPrivateThread(cmB.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    writeActivityConfig.setFrsTabInfo(cmB.frsTabInfo);
                    writeActivityConfig.setProfessionZone(cmB.defaultZone);
                    writeActivityConfig.setForumDir(cmB.firstDir, cmB.secondDir);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.mWP.dJc()) {
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
        if (this.mUf != null) {
            this.mUf.JT(i);
        }
        this.mWP.mWZ.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mWP != null) {
            this.mWP.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.mUf != null) {
            this.mUf.onDestroy();
        }
        super.onDestroy();
    }
}
