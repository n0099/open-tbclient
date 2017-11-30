package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes2.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private g hhF;
    private boolean hjG = true;
    private h hjH;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hjG = false;
        this.hhF = new g(getPageContext(), this.hjG, new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHl() {
                WriteMultiImgsActivity.this.hjH.bIh();
                WriteMultiImgsActivity.this.hjH.om(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHm() {
                WriteMultiImgsActivity.this.hjH.bIi();
                WriteMultiImgsActivity.this.hjH.om(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean z(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hjH.B(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHn() {
                WriteMultiImgsActivity.this.hjH.bHn();
            }
        });
        setContentView(this.hhF.cwl);
        this.hjH = new h(getPageContext(), this.hhF, bundle);
        if (this.hjG) {
            if (this.hjH.bIn() != null) {
                i = this.hjH.bIn().size();
                i2 = this.hjH.bIn().size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hjH != null && this.hjH.hjT != null) {
            bundle.putInt("OutState_Current_Index", this.hjH.hjT.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hjH.bIl());
            bundle.putSerializable("OutState_Write_Info_Data", this.hjH.alz());
            this.hjH.hjT.oe(true);
            if (this.hjH.bIn() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hjH.bIn().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bIh() {
        if (this.hjH != null) {
            this.hjH.bIh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bIi() {
        if (this.hjH != null) {
            this.hjH.bIi();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hjH != null) {
            if (1 == this.hjH.bIl()) {
                ForumWriteData alz = this.hjH.alz();
                if (alz != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, alz.forumId, alz.forumName, null, null, 0, alz.antiData, 13003, false, false, null, false, false, null, null, alz.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", alz.mFrom);
                    writeActivityConfig.setCallFrom(alz.writeCallFrom);
                    writeActivityConfig.setForumLevel(alz.forumLevel);
                    writeActivityConfig.setForumAvatar(alz.avatar);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.hjH.bIl()) {
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
                intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, writeImagesInfo.toJsonString());
                if (!v.w(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.hhF != null) {
            this.hhF.wi(i);
        }
    }
}
