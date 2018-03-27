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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes2.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private g hKt;
    private boolean hMw = true;
    private h hMx;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hMw = false;
        this.hKt = new g(getPageContext(), this.hMw, new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bIg() {
                WriteMultiImgsActivity.this.hMx.bJf();
                WriteMultiImgsActivity.this.hMx.ob(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bIh() {
                WriteMultiImgsActivity.this.hMx.bJg();
                WriteMultiImgsActivity.this.hMx.ob(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean D(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hMx.F(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bIi() {
                WriteMultiImgsActivity.this.hMx.bIi();
            }
        });
        setContentView(this.hKt.dsA);
        this.hMx = new h(getPageContext(), this.hKt, bundle);
        if (this.hMw) {
            if (this.hMx.bJl() != null) {
                i = this.hMx.bJl().size();
                i2 = this.hMx.bJl().size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
        if (this.hMx.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.hMx.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hMx != null && this.hMx.hMJ != null) {
            bundle.putInt("OutState_Current_Index", this.hMx.hMJ.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hMx.bJj());
            bundle.putSerializable("OutState_Write_Info_Data", this.hMx.avo());
            this.hMx.hMJ.nS(true);
            if (this.hMx.bJl() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hMx.bJl().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bJf() {
        if (this.hMx != null) {
            this.hMx.bJf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bJg() {
        if (this.hMx != null) {
            this.hMx.bJg();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hMx != null) {
            if (1 == this.hMx.bJj()) {
                ForumWriteData avo = this.hMx.avo();
                if (avo != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, avo.forumId, avo.forumName, null, null, 0, avo.antiData, 13003, false, false, null, false, false, null, null, avo.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", avo.mFrom);
                    writeActivityConfig.setCallFrom(avo.writeCallFrom);
                    writeActivityConfig.setForumLevel(avo.forumLevel);
                    writeActivityConfig.setForumAvatar(avo.avatar);
                    writeActivityConfig.setPrivateThread(avo.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.hMx.bJj()) {
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
                if (!v.E(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.hKt != null) {
            this.hKt.xP(i);
        }
    }
}
