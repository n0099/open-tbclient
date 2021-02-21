package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes8.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private j ojK;
    private k omK;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.ojK = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dYa() {
                WriteMultiImgsActivity.this.omK.dZC();
                WriteMultiImgsActivity.this.omK.zM(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dYb() {
                WriteMultiImgsActivity.this.omK.dZH();
                WriteMultiImgsActivity.this.omK.zM(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean T(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.omK.V(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dYc() {
                WriteMultiImgsActivity.this.omK.dYc();
            }
        });
        setContentView(this.ojK.iTF);
        this.omK = new k(getPageContext(), this.ojK, bundle);
        if (this.omK.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.omK.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.omK != null && this.omK.omU != null) {
            bundle.putInt("OutState_Current_Index", this.omK.omU.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.omK.dZF());
            bundle.putSerializable("OutState_Write_Info_Data", this.omK.cDk());
            this.omK.omU.zG(true);
            if (this.omK.dZI() != null) {
                bundle.putString("OutState_Write_Img_Info", this.omK.dZI().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dZC() {
        if (this.omK != null) {
            this.omK.dZC();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.omK != null) {
            if (1 == this.omK.dZF()) {
                ForumWriteData cDk = this.omK.cDk();
                if (cDk != null) {
                    if (!WriteActivityConfig.isAsyncWriting()) {
                        WriteActivityConfig.newInstance(this).setType(10).setForumWriteData(cDk).setWriteImagesInfo(writeImagesInfo).send();
                    } else {
                        return;
                    }
                }
            } else if (2 == this.omK.dZF()) {
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
        if (this.ojK != null) {
            this.ojK.LE(i);
        }
        this.omK.omU.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.omK != null) {
            this.omK.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.ojK != null) {
            this.ojK.onDestroy();
        }
        super.onDestroy();
    }
}
