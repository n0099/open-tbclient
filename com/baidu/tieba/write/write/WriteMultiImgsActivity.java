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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes2.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private g hky;
    private boolean hmy = true;
    private h hmz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hmy = false;
        this.hky = new g(getPageContext(), this.hmy, new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHY() {
                WriteMultiImgsActivity.this.hmz.bIU();
                WriteMultiImgsActivity.this.hmz.on(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bHZ() {
                WriteMultiImgsActivity.this.hmz.bIV();
                WriteMultiImgsActivity.this.hmz.on(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean A(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hmz.C(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bIa() {
                WriteMultiImgsActivity.this.hmz.bIa();
            }
        });
        setContentView(this.hky.cwu);
        this.hmz = new h(getPageContext(), this.hky, bundle);
        if (this.hmy) {
            if (this.hmz.bJa() != null) {
                i = this.hmz.bJa().size();
                i2 = this.hmz.bJa().size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hmz != null && this.hmz.hmL != null) {
            bundle.putInt("OutState_Current_Index", this.hmz.hmL.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hmz.bIY());
            bundle.putSerializable("OutState_Write_Info_Data", this.hmz.alI());
            this.hmz.hmL.of(true);
            if (this.hmz.bJa() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hmz.bJa().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bIU() {
        if (this.hmz != null) {
            this.hmz.bIU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bIV() {
        if (this.hmz != null) {
            this.hmz.bIV();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hmz != null) {
            if (1 == this.hmz.bIY()) {
                ForumWriteData alI = this.hmz.alI();
                if (alI != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, alI.forumId, alI.forumName, null, null, 0, alI.antiData, 13003, false, false, null, false, false, null, null, alI.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", alI.mFrom);
                    writeActivityConfig.setCallFrom(alI.writeCallFrom);
                    writeActivityConfig.setForumLevel(alI.forumLevel);
                    writeActivityConfig.setForumAvatar(alI.avatar);
                    writeActivityConfig.setPrivateThread(alI.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.hmz.bIY()) {
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
        if (this.hky != null) {
            this.hky.wv(i);
        }
    }
}
