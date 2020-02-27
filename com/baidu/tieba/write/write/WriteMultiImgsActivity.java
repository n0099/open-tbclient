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
    private h kRT;
    private i kUc;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.kRT = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cVB() {
                WriteMultiImgsActivity.this.kUc.cWE();
                WriteMultiImgsActivity.this.kUc.tW(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cVC() {
                WriteMultiImgsActivity.this.kUc.cWJ();
                WriteMultiImgsActivity.this.kUc.tW(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean N(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.kUc.P(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cVD() {
                WriteMultiImgsActivity.this.kUc.cVD();
            }
        });
        setContentView(this.kRT.gby);
        this.kUc = new i(getPageContext(), this.kRT, bundle);
        if (this.kUc.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.kUc.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.kUc != null && this.kUc.kUm != null) {
            bundle.putInt("OutState_Current_Index", this.kUc.kUm.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.kUc.cWH());
            bundle.putSerializable("OutState_Write_Info_Data", this.kUc.bEr());
            this.kUc.kUm.tR(true);
            if (this.kUc.cWK() != null) {
                bundle.putString("OutState_Write_Img_Info", this.kUc.cWK().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cWE() {
        if (this.kUc != null) {
            this.kUc.cWE();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.kUc != null) {
            if (1 == this.kUc.cWH()) {
                ForumWriteData bEr = this.kUc.bEr();
                if (bEr != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bEr.forumId, bEr.forumName, null, null, 0, bEr.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bEr.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bEr.mFrom);
                    writeActivityConfig.setCallFrom(bEr.writeCallFrom);
                    writeActivityConfig.setForumLevel(bEr.forumLevel);
                    writeActivityConfig.setForumAvatar(bEr.avatar);
                    writeActivityConfig.setPrivateThread(bEr.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.kUc.cWH()) {
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
        if (this.kRT != null) {
            this.kRT.Ew(i);
        }
        this.kUc.kUm.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kUc != null) {
            this.kUc.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.kRT != null) {
            this.kRT.onDestroy();
        }
        super.onDestroy();
    }
}
