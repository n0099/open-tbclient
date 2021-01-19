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
    private j nZp;
    private k ocs;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.nZp = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dVH() {
                WriteMultiImgsActivity.this.ocs.dXj();
                WriteMultiImgsActivity.this.ocs.zr(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dVI() {
                WriteMultiImgsActivity.this.ocs.dXo();
                WriteMultiImgsActivity.this.ocs.zr(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean U(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.ocs.W(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dVJ() {
                WriteMultiImgsActivity.this.ocs.dVJ();
            }
        });
        setContentView(this.nZp.iNK);
        this.ocs = new k(getPageContext(), this.nZp, bundle);
        if (this.ocs.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.ocs.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.ocs != null && this.ocs.ocC != null) {
            bundle.putInt("OutState_Current_Index", this.ocs.ocC.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.ocs.dXm());
            bundle.putSerializable("OutState_Write_Info_Data", this.ocs.cBR());
            this.ocs.ocC.zl(true);
            if (this.ocs.dXp() != null) {
                bundle.putString("OutState_Write_Img_Info", this.ocs.dXp().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dXj() {
        if (this.ocs != null) {
            this.ocs.dXj();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.ocs != null) {
            if (1 == this.ocs.dXm()) {
                ForumWriteData cBR = this.ocs.cBR();
                if (cBR != null) {
                    if (!WriteActivityConfig.isAsyncWriting()) {
                        WriteActivityConfig.newInstance(this).setType(10).setForumWriteData(cBR).setWriteImagesInfo(writeImagesInfo).send();
                    } else {
                        return;
                    }
                }
            } else if (2 == this.ocs.dXm()) {
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
        if (this.nZp != null) {
            this.nZp.Lj(i);
        }
        this.ocs.ocC.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ocs != null) {
            this.ocs.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.nZp != null) {
            this.nZp.onDestroy();
        }
        super.onDestroy();
    }
}
