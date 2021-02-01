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
    private j ojk;
    private k omk;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.ojk = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dXS() {
                WriteMultiImgsActivity.this.omk.dZu();
                WriteMultiImgsActivity.this.omk.zM(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dXT() {
                WriteMultiImgsActivity.this.omk.dZz();
                WriteMultiImgsActivity.this.omk.zM(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean T(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.omk.V(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dXU() {
                WriteMultiImgsActivity.this.omk.dXU();
            }
        });
        setContentView(this.ojk.iTr);
        this.omk = new k(getPageContext(), this.ojk, bundle);
        if (this.omk.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.omk.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.omk != null && this.omk.omu != null) {
            bundle.putInt("OutState_Current_Index", this.omk.omu.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.omk.dZx());
            bundle.putSerializable("OutState_Write_Info_Data", this.omk.cDd());
            this.omk.omu.zG(true);
            if (this.omk.dZA() != null) {
                bundle.putString("OutState_Write_Img_Info", this.omk.dZA().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dZu() {
        if (this.omk != null) {
            this.omk.dZu();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.omk != null) {
            if (1 == this.omk.dZx()) {
                ForumWriteData cDd = this.omk.cDd();
                if (cDd != null) {
                    if (!WriteActivityConfig.isAsyncWriting()) {
                        WriteActivityConfig.newInstance(this).setType(10).setForumWriteData(cDd).setWriteImagesInfo(writeImagesInfo).send();
                    } else {
                        return;
                    }
                }
            } else if (2 == this.omk.dZx()) {
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
        if (this.ojk != null) {
            this.ojk.LD(i);
        }
        this.omk.omu.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.omk != null) {
            this.omk.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.ojk != null) {
            this.ojk.onDestroy();
        }
        super.onDestroy();
    }
}
