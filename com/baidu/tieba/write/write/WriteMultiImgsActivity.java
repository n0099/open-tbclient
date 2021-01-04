package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes8.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private j odW;
    private k ogY;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.odW = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dZy() {
                WriteMultiImgsActivity.this.ogY.eba();
                WriteMultiImgsActivity.this.ogY.zv(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dZz() {
                WriteMultiImgsActivity.this.ogY.ebf();
                WriteMultiImgsActivity.this.ogY.zv(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean U(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.ogY.W(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dZA() {
                WriteMultiImgsActivity.this.ogY.dZA();
            }
        });
        setContentView(this.odW.iSr);
        this.ogY = new k(getPageContext(), this.odW, bundle);
        if (this.ogY.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.ogY.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.ogY != null && this.ogY.ohi != null) {
            bundle.putInt("OutState_Current_Index", this.ogY.ohi.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.ogY.ebd());
            bundle.putSerializable("OutState_Write_Info_Data", this.ogY.cFI());
            this.ogY.ohi.zp(true);
            if (this.ogY.ebg() != null) {
                bundle.putString("OutState_Write_Img_Info", this.ogY.ebg().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eba() {
        if (this.ogY != null) {
            this.ogY.eba();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.ogY != null) {
            if (1 == this.ogY.ebd()) {
                ForumWriteData cFI = this.ogY.cFI();
                if (cFI != null) {
                    if (!WriteActivityConfig.isAsyncWriting()) {
                        WriteActivityConfig.newInstance(this).setType(10).setForumWriteData(cFI).setWriteImagesInfo(writeImagesInfo).send();
                    } else {
                        return;
                    }
                }
            } else if (2 == this.ogY.ebd()) {
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
                if (!x.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.odW != null) {
            this.odW.MQ(i);
        }
        this.ogY.ohi.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ogY != null) {
            this.ogY.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.odW != null) {
            this.odW.onDestroy();
        }
        super.onDestroy();
    }
}
