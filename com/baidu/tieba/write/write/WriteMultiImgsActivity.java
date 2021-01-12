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
/* loaded from: classes7.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private j nZo;
    private k ocq;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.nZo = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dVH() {
                WriteMultiImgsActivity.this.ocq.dXj();
                WriteMultiImgsActivity.this.ocq.zr(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dVI() {
                WriteMultiImgsActivity.this.ocq.dXo();
                WriteMultiImgsActivity.this.ocq.zr(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean U(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.ocq.W(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dVJ() {
                WriteMultiImgsActivity.this.ocq.dVJ();
            }
        });
        setContentView(this.nZo.iNK);
        this.ocq = new k(getPageContext(), this.nZo, bundle);
        if (this.ocq.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.ocq.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.ocq != null && this.ocq.ocB != null) {
            bundle.putInt("OutState_Current_Index", this.ocq.ocB.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.ocq.dXm());
            bundle.putSerializable("OutState_Write_Info_Data", this.ocq.cBR());
            this.ocq.ocB.zl(true);
            if (this.ocq.dXp() != null) {
                bundle.putString("OutState_Write_Img_Info", this.ocq.dXp().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dXj() {
        if (this.ocq != null) {
            this.ocq.dXj();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.ocq != null) {
            if (1 == this.ocq.dXm()) {
                ForumWriteData cBR = this.ocq.cBR();
                if (cBR != null) {
                    if (!WriteActivityConfig.isAsyncWriting()) {
                        WriteActivityConfig.newInstance(this).setType(10).setForumWriteData(cBR).setWriteImagesInfo(writeImagesInfo).send();
                    } else {
                        return;
                    }
                }
            } else if (2 == this.ocq.dXm()) {
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
        if (this.nZo != null) {
            this.nZo.Lj(i);
        }
        this.ocq.ocB.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ocq != null) {
            this.ocq.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.nZo != null) {
            this.nZo.onDestroy();
        }
        super.onDestroy();
    }
}
