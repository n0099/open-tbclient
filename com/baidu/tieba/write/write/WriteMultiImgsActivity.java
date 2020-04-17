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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes2.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h lDK;
    private i lFU;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.lDK = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dgJ() {
                WriteMultiImgsActivity.this.lFU.dhN();
                WriteMultiImgsActivity.this.lFU.vf(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dgK() {
                WriteMultiImgsActivity.this.lFU.dhS();
                WriteMultiImgsActivity.this.lFU.vf(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean Q(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.lFU.S(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dgL() {
                WriteMultiImgsActivity.this.lFU.dgL();
            }
        });
        setContentView(this.lDK.gLG);
        this.lFU = new i(getPageContext(), this.lDK, bundle);
        if (this.lFU.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.lFU.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.lFU != null && this.lFU.lGe != null) {
            bundle.putInt("OutState_Current_Index", this.lFU.lGe.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.lFU.dhQ());
            bundle.putSerializable("OutState_Write_Info_Data", this.lFU.bPc());
            this.lFU.lGe.va(true);
            if (this.lFU.dhT() != null) {
                bundle.putString("OutState_Write_Img_Info", this.lFU.dhT().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dhN() {
        if (this.lFU != null) {
            this.lFU.dhN();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.lFU != null) {
            if (1 == this.lFU.dhQ()) {
                ForumWriteData bPc = this.lFU.bPc();
                if (bPc != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bPc.forumId, bPc.forumName, null, null, 0, bPc.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bPc.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bPc.mFrom);
                    writeActivityConfig.setCallFrom(bPc.writeCallFrom);
                    writeActivityConfig.setForumLevel(bPc.forumLevel);
                    writeActivityConfig.setForumAvatar(bPc.avatar);
                    writeActivityConfig.setPrivateThread(bPc.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.lFU.dhQ()) {
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
                if (!v.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.lDK != null) {
            this.lDK.Fe(i);
        }
        this.lFU.lGe.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lFU != null) {
            this.lFU.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.lDK != null) {
            this.lDK.onDestroy();
        }
        super.onDestroy();
    }
}
