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
/* loaded from: classes7.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private j olP;
    private k ooQ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.olP = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dYi() {
                WriteMultiImgsActivity.this.ooQ.dZK();
                WriteMultiImgsActivity.this.ooQ.zL(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dYj() {
                WriteMultiImgsActivity.this.ooQ.dZP();
                WriteMultiImgsActivity.this.ooQ.zL(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean T(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.ooQ.V(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dYk() {
                WriteMultiImgsActivity.this.ooQ.dYk();
            }
        });
        setContentView(this.olP.iVo);
        this.ooQ = new k(getPageContext(), this.olP, bundle);
        if (this.ooQ.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.ooQ.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.ooQ != null && this.ooQ.opa != null) {
            bundle.putInt("OutState_Current_Index", this.ooQ.opa.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.ooQ.dZN());
            bundle.putSerializable("OutState_Write_Info_Data", this.ooQ.cDq());
            this.ooQ.opa.zF(true);
            if (this.ooQ.dZQ() != null) {
                bundle.putString("OutState_Write_Img_Info", this.ooQ.dZQ().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dZK() {
        if (this.ooQ != null) {
            this.ooQ.dZK();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.ooQ != null) {
            if (1 == this.ooQ.dZN()) {
                ForumWriteData cDq = this.ooQ.cDq();
                if (cDq != null) {
                    if (!WriteActivityConfig.isAsyncWriting()) {
                        WriteActivityConfig.newInstance(this).setType(10).setForumWriteData(cDq).setWriteImagesInfo(writeImagesInfo).send();
                    } else {
                        return;
                    }
                }
            } else if (2 == this.ooQ.dZN()) {
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
        if (this.olP != null) {
            this.olP.LI(i);
        }
        this.ooQ.opa.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ooQ != null) {
            this.ooQ.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.olP != null) {
            this.olP.onDestroy();
        }
        super.onDestroy();
    }
}
