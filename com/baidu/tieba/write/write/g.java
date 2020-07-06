package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.f;
/* loaded from: classes2.dex */
public class g {
    private TbPageContext<WriteActivity> dPv;
    private WriteImagesInfo mWriteImagesInfo;
    private WriteImageGridView mvn;
    public f mvo;
    private com.baidu.tbadk.img.b euT = new com.baidu.tbadk.img.b();
    private String mFrom = "write";
    private String mForumId = "";
    private f.a mvp = new f.a() { // from class: com.baidu.tieba.write.write.g.1
        @Override // com.baidu.tieba.write.write.f.a
        public void GQ(int i) {
            if (g.this.mWriteImagesInfo != null && g.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < g.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = g.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.kh().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                g.this.mvo.a(g.this.mWriteImagesInfo);
                g.this.mvo.notifyDataSetChanged();
                if (w.isEmpty(g.this.mWriteImagesInfo.getChosedFiles()) && g.this.dPv.getOrignalPage() != 0) {
                    ((WriteActivity) g.this.dPv.getOrignalPage()).deD();
                }
                if (g.this.dPv.getPageActivity() instanceof WriteActivity) {
                    ((WriteActivity) g.this.dPv.getPageActivity()).dtG();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void GX(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (g.this.mWriteImagesInfo != null && (count = w.getCount(g.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < count && (imageInfoAt = g.this.mWriteImagesInfo.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                g.this.dPv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(g.this.dPv.getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, g.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.f.a
        public void dtN() {
            if (g.this.mWriteImagesInfo != null) {
                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(g.this.dPv.getPageActivity(), g.this.mWriteImagesInfo.toJsonString(), true, true);
                albumFloatActivityConfig.getIntent().putExtra("forum_id", g.this.mForumId);
                albumFloatActivityConfig.getIntent().putExtra("from", g.this.mFrom);
                albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                if (g.this.dPv.getPageActivity() instanceof WriteActivity) {
                    albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) g.this.dPv.getPageActivity()).drs());
                    AntiData antiData = new AntiData();
                    antiData.voice_message = ((WriteActivity) g.this.dPv.getPageActivity()).evB;
                    antiData.setIfVoice(((WriteActivity) g.this.dPv.getPageActivity()).mui);
                    albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) g.this.dPv.getPageActivity()).mPrefixData, ((WriteActivity) g.this.dPv.getPageActivity()).lvi.getFirstDir(), ((WriteActivity) g.this.dPv.getPageActivity()).lvi.getSecondDir());
                }
                albumFloatActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
            }
        }
    };

    public g(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.dPv = tbPageContext;
        this.mvn = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        this.mvo = new f(view.getContext(), this.euT, null, this.mvp);
        this.mvn.setAdapter((ListAdapter) this.mvo);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.mvo.a(this.mWriteImagesInfo);
        this.mvo.notifyDataSetChanged();
    }

    public GridView dtO() {
        return this.mvn;
    }

    public void destroy() {
        this.euT.cancelAllAsyncTask();
    }

    public void vL(boolean z) {
        this.mvo.vL(z);
    }
}
