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
    private j odV;
    private k ogX;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.odV = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dZz() {
                WriteMultiImgsActivity.this.ogX.ebb();
                WriteMultiImgsActivity.this.ogX.zv(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dZA() {
                WriteMultiImgsActivity.this.ogX.ebg();
                WriteMultiImgsActivity.this.ogX.zv(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean U(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.ogX.W(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dZB() {
                WriteMultiImgsActivity.this.ogX.dZB();
            }
        });
        setContentView(this.odV.iSr);
        this.ogX = new k(getPageContext(), this.odV, bundle);
        if (this.ogX.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.ogX.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.ogX != null && this.ogX.ohh != null) {
            bundle.putInt("OutState_Current_Index", this.ogX.ohh.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.ogX.ebe());
            bundle.putSerializable("OutState_Write_Info_Data", this.ogX.cFJ());
            this.ogX.ohh.zp(true);
            if (this.ogX.ebh() != null) {
                bundle.putString("OutState_Write_Img_Info", this.ogX.ebh().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ebb() {
        if (this.ogX != null) {
            this.ogX.ebb();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.ogX != null) {
            if (1 == this.ogX.ebe()) {
                ForumWriteData cFJ = this.ogX.cFJ();
                if (cFJ != null) {
                    if (!WriteActivityConfig.isAsyncWriting()) {
                        WriteActivityConfig.newInstance(this).setType(10).setForumWriteData(cFJ).setWriteImagesInfo(writeImagesInfo).send();
                    } else {
                        return;
                    }
                }
            } else if (2 == this.ogX.ebe()) {
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
        if (this.odV != null) {
            this.odV.MQ(i);
        }
        this.ogX.ohh.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ogX != null) {
            this.ogX.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.odV != null) {
            this.odV.onDestroy();
        }
        super.onDestroy();
    }
}
