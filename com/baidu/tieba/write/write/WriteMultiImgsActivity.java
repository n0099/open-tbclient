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
    private g hSJ;
    private boolean hUJ = true;
    private h hUK;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        int i2 = 1;
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.hUJ = false;
        this.hSJ = new g(getPageContext(), this.hUJ, new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bNM() {
                WriteMultiImgsActivity.this.hUK.bOI();
                WriteMultiImgsActivity.this.hUK.oI(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bNN() {
                WriteMultiImgsActivity.this.hUK.bOJ();
                WriteMultiImgsActivity.this.hUK.oI(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean A(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.hUK.C(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void bNO() {
                WriteMultiImgsActivity.this.hUK.bNO();
            }
        });
        setContentView(this.hSJ.dkU);
        this.hUK = new h(getPageContext(), this.hSJ, bundle);
        if (this.hUJ) {
            if (this.hUK.bOO() != null) {
                i = this.hUK.bOO().size();
                i2 = this.hUK.bOO().size();
            } else {
                i = 1;
            }
            TbadkCoreApplication.getInst().sendImagePv(i, i2, "motu_pic");
        }
        if (this.hSJ != null) {
            this.hSJ.zm(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.hUK != null && this.hUK.hUW != null) {
            bundle.putInt("OutState_Current_Index", this.hUK.hUW.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.hUK.bOM());
            bundle.putSerializable("OutState_Write_Info_Data", this.hUK.atr());
            this.hUK.hUW.oA(true);
            if (this.hUK.bOO() != null) {
                bundle.putString("OutState_Write_Img_Info", this.hUK.bOO().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOI() {
        if (this.hUK != null) {
            this.hUK.bOI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOJ() {
        if (this.hUK != null) {
            this.hUK.bOJ();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.hUK != null) {
            if (1 == this.hUK.bOM()) {
                ForumWriteData atr = this.hUK.atr();
                if (atr != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, atr.forumId, atr.forumName, null, null, 0, atr.antiData, 13003, false, false, null, false, false, null, null, atr.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", atr.mFrom);
                    writeActivityConfig.setCallFrom(atr.writeCallFrom);
                    writeActivityConfig.setForumLevel(atr.forumLevel);
                    writeActivityConfig.setForumAvatar(atr.avatar);
                    writeActivityConfig.setPrivateThread(atr.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.hUK.bOM()) {
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
                if (!v.G(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.hSJ != null) {
            this.hSJ.zm(i);
        }
    }
}
