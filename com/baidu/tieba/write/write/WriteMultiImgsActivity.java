package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private j obJ;
    private k oeJ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.obJ = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void eao() {
                WriteMultiImgsActivity.this.oeJ.ebN();
                WriteMultiImgsActivity.this.oeJ.zx(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void eap() {
                WriteMultiImgsActivity.this.oeJ.ebS();
                WriteMultiImgsActivity.this.oeJ.zx(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean U(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.oeJ.W(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void eaq() {
                WriteMultiImgsActivity.this.oeJ.eaq();
            }
        });
        setContentView(this.obJ.iGd);
        this.oeJ = new k(getPageContext(), this.obJ, bundle);
        if (this.oeJ.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.oeJ.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.oeJ != null && this.oeJ.oeT != null) {
            bundle.putInt("OutState_Current_Index", this.oeJ.oeT.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.oeJ.ebQ());
            bundle.putSerializable("OutState_Write_Info_Data", this.oeJ.cCN());
            this.oeJ.oeT.zs(true);
            if (this.oeJ.ebT() != null) {
                bundle.putString("OutState_Write_Img_Info", this.oeJ.ebT().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ebN() {
        if (this.oeJ != null) {
            this.oeJ.ebN();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.oeJ != null) {
            if (1 == this.oeJ.ebQ()) {
                ForumWriteData cCN = this.oeJ.cCN();
                if (cCN != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, cCN.forumId, cCN.forumName, null, null, 0, cCN.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, cCN.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", cCN.mFrom);
                    writeActivityConfig.setCallFrom(cCN.writeCallFrom);
                    writeActivityConfig.setForumLevel(cCN.forumLevel);
                    writeActivityConfig.setForumAvatar(cCN.avatar);
                    writeActivityConfig.setPrivateThread(cCN.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    writeActivityConfig.setFrsTabInfo(cCN.frsTabInfo);
                    writeActivityConfig.setProfessionZone(cCN.defaultZone);
                    writeActivityConfig.setForumDir(cCN.firstDir, cCN.secondDir);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.oeJ.ebQ()) {
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
        if (this.obJ != null) {
            this.obJ.Ne(i);
        }
        this.oeJ.oeT.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.oeJ != null) {
            this.oeJ.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.obJ != null) {
            this.obJ.onDestroy();
        }
        super.onDestroy();
    }
}
