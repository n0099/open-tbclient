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
/* loaded from: classes13.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h kRV;
    private i kUe;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.kRV = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cVD() {
                WriteMultiImgsActivity.this.kUe.cWG();
                WriteMultiImgsActivity.this.kUe.tW(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cVE() {
                WriteMultiImgsActivity.this.kUe.cWL();
                WriteMultiImgsActivity.this.kUe.tW(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean N(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.kUe.P(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cVF() {
                WriteMultiImgsActivity.this.kUe.cVF();
            }
        });
        setContentView(this.kRV.gbA);
        this.kUe = new i(getPageContext(), this.kRV, bundle);
        if (this.kUe.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.kUe.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.kUe != null && this.kUe.kUo != null) {
            bundle.putInt("OutState_Current_Index", this.kUe.kUo.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.kUe.cWJ());
            bundle.putSerializable("OutState_Write_Info_Data", this.kUe.bEt());
            this.kUe.kUo.tR(true);
            if (this.kUe.cWM() != null) {
                bundle.putString("OutState_Write_Img_Info", this.kUe.cWM().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cWG() {
        if (this.kUe != null) {
            this.kUe.cWG();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.kUe != null) {
            if (1 == this.kUe.cWJ()) {
                ForumWriteData bEt = this.kUe.bEt();
                if (bEt != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bEt.forumId, bEt.forumName, null, null, 0, bEt.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bEt.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bEt.mFrom);
                    writeActivityConfig.setCallFrom(bEt.writeCallFrom);
                    writeActivityConfig.setForumLevel(bEt.forumLevel);
                    writeActivityConfig.setForumAvatar(bEt.avatar);
                    writeActivityConfig.setPrivateThread(bEt.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.kUe.cWJ()) {
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
        if (this.kRV != null) {
            this.kRV.Ew(i);
        }
        this.kUe.kUo.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kUe != null) {
            this.kUe.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.kRV != null) {
            this.kRV.onDestroy();
        }
        super.onDestroy();
    }
}
