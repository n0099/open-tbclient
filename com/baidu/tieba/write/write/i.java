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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.h;
/* loaded from: classes7.dex */
public class i {
    private TbPageContext<WriteActivity> eSJ;
    private WriteImagesInfo mWriteImagesInfo;
    private WriteImageGridView ocn;
    public h oco;
    private com.baidu.tbadk.img.b fAo = new com.baidu.tbadk.img.b();
    private String mFrom = "write";
    private String mForumId = "";
    private h.a ocp = new h.a() { // from class: com.baidu.tieba.write.write.i.1
        @Override // com.baidu.tieba.write.write.h.a
        public void KY(int i) {
            if (i.this.mWriteImagesInfo != null && i.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < i.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = i.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lh().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                i.this.oco.a(i.this.mWriteImagesInfo);
                i.this.oco.notifyDataSetChanged();
                if (x.isEmpty(i.this.mWriteImagesInfo.getChosedFiles()) && i.this.eSJ.getOrignalPage() != 0) {
                    ((WriteActivity) i.this.eSJ.getOrignalPage()).dHG();
                }
                if (i.this.eSJ.getPageActivity() instanceof WriteActivity) {
                    ((WriteActivity) i.this.eSJ.getPageActivity()).dWW();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void Li(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.mWriteImagesInfo != null && (count = x.getCount(i.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < count && (imageInfoAt = i.this.mWriteImagesInfo.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                i.this.eSJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(i.this.eSJ.getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, i.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void dXi() {
            if (i.this.mWriteImagesInfo != null) {
                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.eSJ.getPageActivity(), i.this.mWriteImagesInfo.toJsonString(), true, true);
                albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.mForumId);
                albumFloatActivityConfig.getIntent().putExtra("from", i.this.mFrom);
                albumFloatActivityConfig.setRequestCode(12002);
                if (i.this.eSJ.getPageActivity() instanceof WriteActivity) {
                    albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.eSJ.getPageActivity()).dUE());
                    AntiData antiData = new AntiData();
                    antiData.voice_message = ((WriteActivity) i.this.eSJ.getPageActivity()).fBw;
                    antiData.setIfVoice(((WriteActivity) i.this.eSJ.getPageActivity()).oaE);
                    albumFloatActivityConfig.setStatisticFrom(((WriteActivity) i.this.eSJ.getPageActivity()).ncc.getStatisticFrom());
                    albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.eSJ.getPageActivity()).mPrefixData, ((WriteActivity) i.this.eSJ.getPageActivity()).ncc.getFirstDir(), ((WriteActivity) i.this.eSJ.getPageActivity()).ncc.getSecondDir());
                }
                albumFloatActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
            }
        }
    };

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eSJ = tbPageContext;
        this.ocn = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        this.oco = new h(view.getContext(), this.fAo, null, this.ocp);
        this.ocn.setAdapter((ListAdapter) this.oco);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.oco.a(this.mWriteImagesInfo);
        this.oco.notifyDataSetChanged();
    }

    public GridView Wf() {
        return this.ocn;
    }

    public void destroy() {
        this.fAo.cancelAllAsyncTask();
    }

    public void zf(boolean z) {
        this.oco.zf(z);
    }
}
