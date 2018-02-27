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
    private g hJV;
    private boolean hLY = true;
    private h hLZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hLY = false;
        this.hJV = new g(getPageContext(), this.hLY, new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bIb() {
                WriteMultiImgsActivity.this.hLZ.bJa();
                WriteMultiImgsActivity.this.hLZ.nW(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bIc() {
                WriteMultiImgsActivity.this.hLZ.bJb();
                WriteMultiImgsActivity.this.hLZ.nW(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean D(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hLZ.F(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bId() {
                WriteMultiImgsActivity.this.hLZ.bId();
            }
        });
        setContentView(this.hJV.dsx);
        this.hLZ = new h(getPageContext(), this.hJV, bundle);
        if (this.hLY) {
            if (this.hLZ.bJg() != null) {
                i = this.hLZ.bJg().size();
                i2 = this.hLZ.bJg().size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
        if (this.hLZ.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.hLZ.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hLZ != null && this.hLZ.hMl != null) {
            bundle.putInt("OutState_Current_Index", this.hLZ.hMl.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hLZ.bJe());
            bundle.putSerializable("OutState_Write_Info_Data", this.hLZ.avn());
            this.hLZ.hMl.nN(true);
            if (this.hLZ.bJg() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hLZ.bJg().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bJa() {
        if (this.hLZ != null) {
            this.hLZ.bJa();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bJb() {
        if (this.hLZ != null) {
            this.hLZ.bJb();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hLZ != null) {
            if (1 == this.hLZ.bJe()) {
                ForumWriteData avn = this.hLZ.avn();
                if (avn != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, avn.forumId, avn.forumName, null, null, 0, avn.antiData, 13003, false, false, null, false, false, null, null, avn.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", avn.mFrom);
                    writeActivityConfig.setCallFrom(avn.writeCallFrom);
                    writeActivityConfig.setForumLevel(avn.forumLevel);
                    writeActivityConfig.setForumAvatar(avn.avatar);
                    writeActivityConfig.setPrivateThread(avn.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.hLZ.bJe()) {
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
        if (this.hJV != null) {
            this.hJV.xP(i);
        }
    }
}
