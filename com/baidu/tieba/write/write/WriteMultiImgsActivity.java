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
/* loaded from: classes3.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h hhf;
    private i hjo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hhf = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bCQ() {
                WriteMultiImgsActivity.this.hjo.bDR();
                WriteMultiImgsActivity.this.hjo.nB(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bCR() {
                WriteMultiImgsActivity.this.hjo.bDW();
                WriteMultiImgsActivity.this.hjo.nB(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean H(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hjo.J(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bCS() {
                WriteMultiImgsActivity.this.hjo.bCS();
            }
        });
        setContentView(this.hhf.cMv);
        this.hjo = new i(getPageContext(), this.hhf, bundle);
        if (this.hjo.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.hjo.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hjo != null && this.hjo.hjy != null) {
            bundle.putInt("OutState_Current_Index", this.hjo.hjy.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hjo.bDU());
            bundle.putSerializable("OutState_Write_Info_Data", this.hjo.apG());
            this.hjo.hjy.nv(true);
            if (this.hjo.bDX() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hjo.bDX().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bDR() {
        if (this.hjo != null) {
            this.hjo.bDR();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hjo != null) {
            if (1 == this.hjo.bDU()) {
                ForumWriteData apG = this.hjo.apG();
                if (apG != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, apG.forumId, apG.forumName, null, null, 0, apG.antiData, 13003, false, false, null, false, false, null, null, apG.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", apG.mFrom);
                    writeActivityConfig.setCallFrom(apG.writeCallFrom);
                    writeActivityConfig.setForumLevel(apG.forumLevel);
                    writeActivityConfig.setForumAvatar(apG.avatar);
                    writeActivityConfig.setPrivateThread(apG.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            } else if (2 == this.hjo.bDU()) {
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
        if (this.hhf != null) {
            this.hhf.vk(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hjo != null) {
            this.hjo.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.hhf != null) {
            this.hhf.onDestroy();
        }
        super.onDestroy();
    }
}
