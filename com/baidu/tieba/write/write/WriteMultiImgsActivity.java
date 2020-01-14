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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes11.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h kRn;
    private i kTw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.kRn = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cUn() {
                WriteMultiImgsActivity.this.kTw.cVq();
                WriteMultiImgsActivity.this.kTw.tS(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cUo() {
                WriteMultiImgsActivity.this.kTw.cVv();
                WriteMultiImgsActivity.this.kTw.tS(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean N(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.kTw.P(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void cUp() {
                WriteMultiImgsActivity.this.kTw.cUp();
            }
        });
        setContentView(this.kRn.fZy);
        this.kTw = new i(getPageContext(), this.kRn, bundle);
        if (this.kTw.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.kTw.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.kTw != null && this.kTw.kTG != null) {
            bundle.putInt("OutState_Current_Index", this.kTw.kTG.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.kTw.cVt());
            bundle.putSerializable("OutState_Write_Info_Data", this.kTw.bCO());
            this.kTw.kTG.tN(true);
            if (this.kTw.cVw() != null) {
                bundle.putString("OutState_Write_Img_Info", this.kTw.cVw().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cVq() {
        if (this.kTw != null) {
            this.kTw.cVq();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.kTw != null) {
            if (1 == this.kTw.cVt()) {
                ForumWriteData bCO = this.kTw.bCO();
                if (bCO != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bCO.forumId, bCO.forumName, null, null, 0, bCO.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bCO.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bCO.mFrom);
                    writeActivityConfig.setCallFrom(bCO.writeCallFrom);
                    writeActivityConfig.setForumLevel(bCO.forumLevel);
                    writeActivityConfig.setForumAvatar(bCO.avatar);
                    writeActivityConfig.setPrivateThread(bCO.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.kTw.cVt()) {
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
                if (!v.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.kRn != null) {
            this.kRn.Er(i);
        }
        this.kTw.kTG.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kTw != null) {
            this.kTw.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.kRn != null) {
            this.kRn.onDestroy();
        }
        super.onDestroy();
    }
}
