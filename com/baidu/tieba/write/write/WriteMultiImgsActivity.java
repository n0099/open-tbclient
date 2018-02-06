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
    private g hKi;
    private boolean hMl = true;
    private h hMm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hMl = false;
        this.hKi = new g(getPageContext(), this.hMl, new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bIc() {
                WriteMultiImgsActivity.this.hMm.bJb();
                WriteMultiImgsActivity.this.hMm.nW(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bId() {
                WriteMultiImgsActivity.this.hMm.bJc();
                WriteMultiImgsActivity.this.hMm.nW(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean D(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hMm.F(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bIe() {
                WriteMultiImgsActivity.this.hMm.bIe();
            }
        });
        setContentView(this.hKi.dsJ);
        this.hMm = new h(getPageContext(), this.hKi, bundle);
        if (this.hMl) {
            if (this.hMm.bJh() != null) {
                i = this.hMm.bJh().size();
                i2 = this.hMm.bJh().size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
        if (this.hMm.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.hMm.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hMm != null && this.hMm.hMy != null) {
            bundle.putInt("OutState_Current_Index", this.hMm.hMy.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hMm.bJf());
            bundle.putSerializable("OutState_Write_Info_Data", this.hMm.avo());
            this.hMm.hMy.nN(true);
            if (this.hMm.bJh() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hMm.bJh().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bJb() {
        if (this.hMm != null) {
            this.hMm.bJb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bJc() {
        if (this.hMm != null) {
            this.hMm.bJc();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hMm != null) {
            if (1 == this.hMm.bJf()) {
                ForumWriteData avo = this.hMm.avo();
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
            } else if (2 == this.hMm.bJf()) {
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
        if (this.hKi != null) {
            this.hKi.xO(i);
        }
    }
}
