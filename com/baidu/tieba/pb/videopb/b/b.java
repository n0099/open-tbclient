package com.baidu.tieba.pb.videopb.b;

import android.arch.lifecycle.y;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.g;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.c;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class b {
    public ReplyFragment iUM;
    public VideoPbFragment iUN;
    private int iDy = 0;
    boolean iDz = false;
    private final TbRichTextView.i dIi = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r2v57, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            c crb;
            try {
                an anVar = new an("c13398");
                anVar.cp("tid", b.this.iUM.ciU().ckU());
                anVar.cp("fid", b.this.iUM.ciU().getForumId());
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.Z("obj_locate", 3);
                anVar.Z("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(b.this.iUM.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.iUM.ciU().getPbData().cik()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    int i2 = -1;
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().aRg() != null) {
                            ArrayList<TbRichTextImageInfo> aRg = tbRichTextView.getRichText().aRg();
                            int i3 = 0;
                            while (i3 < aRg.size()) {
                                if (aRg.get(i3) != null) {
                                    arrayList.add(aRg.get(i3).getSrc());
                                    if (i2 == -1 && str != null && str.equals(aRg.get(i3).getSrc())) {
                                        i2 = i3;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = aRg.get(i3).getSrc();
                                    imageUrlData.originalUrl = aRg.get(i3).getSrc();
                                    imageUrlData.isLongPic = aRg.get(i3).aRE();
                                    concurrentHashMap.put(aRg.get(i3).getSrc(), imageUrlData);
                                }
                                i3++;
                                i2 = i2;
                            }
                        }
                    }
                    ImageViewerConfig createConfig = new ImageViewerConfig(b.this.iUM.getPageContext().getPageActivity()).createConfig(arrayList, i2, "", "", "", false, "", b.this.iUM.ciU().clm(), concurrentHashMap, true, false, z);
                    createConfig.getIntent().putExtra("from", "pb");
                    if (b.this.iUM.ciU() != null && b.this.iUM.ciU().getPbData() != null) {
                        createConfig.setThreadData(b.this.iUM.ciU().getPbData().chK());
                    }
                    b.this.iUM.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar = new PbActivity.a();
                b.this.a(str, i, aVar);
                if (aVar.izb) {
                    TbRichText bk = b.this.bk(str, i);
                    if (bk != null && b.this.iDy >= 0 && b.this.iDy < bk.aRf().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String b = g.b(bk.aRf().get(b.this.iDy));
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= aVar.iyY.size()) {
                                break;
                            } else if (!aVar.iyY.get(i5).equals(b)) {
                                i4 = i5 + 1;
                            } else {
                                aVar.index = i5;
                                arrayList2.add(b);
                                break;
                            }
                        }
                        if (bk.getPostId() != 0 && (crb = b.this.iUM.crb()) != null) {
                            ArrayList<m> dataList = crb.getDataList();
                            if (v.getCount(dataList) > 0) {
                                Iterator<m> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    m next = it.next();
                                    if ((next instanceof PostData) && bk.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.iUM.ciU().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!v.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar.iyZ.get(str2));
                        }
                        ImageViewerConfig createConfig2 = new ImageViewerConfig(b.this.iUM.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iza, aVar.lastId, b.this.iUM.ciU().clm(), concurrentHashMap2, true, false, z);
                        createConfig2.getIntent().putExtra("from", "pb");
                        createConfig2.setPostId(aVar.postId);
                        if (b.this.iUM.ciU() != null && b.this.iUM.ciU().getPbData() != null) {
                            createConfig2.setThreadData(b.this.iUM.ciU().getPbData().chK());
                        }
                        b.this.iUM.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(v.getItem(aVar.iyY, 0));
                ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                if (!v.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar.iyZ.get(str3));
                }
                ImageViewerConfig createConfig3 = new ImageViewerConfig(b.this.iUM.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iza, aVar.iyY.get(0), b.this.iUM.ciU().clm(), concurrentHashMap3, true, false, z);
                createConfig3.getIntent().putExtra("from", "pb");
                createConfig3.setIsCanDrag(false);
                createConfig3.setPostId(aVar.postId);
                if (b.this.iUM.ciU() != null && b.this.iUM.ciU().getPbData() != null) {
                    createConfig3.setThreadData(b.this.iUM.ciU().getPbData().chK());
                }
                b.this.iUM.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private com.baidu.tieba.pb.a.c dmm = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
            if (b.this.iUN == null || !b.this.iUN.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.iUN != null && b.this.iUN.cp(view)) {
                        return true;
                    }
                } else if (view.getId() == R.id.pb_floor_item_layout) {
                    if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                        b.this.c((SparseArray) view.getTag(R.id.tag_from));
                    }
                } else if ((view instanceof TbRichTextView) || view.getId() == R.id.pb_post_header_layout) {
                    SparseArray sparseArray = null;
                    if (view.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view.getTag();
                    }
                    if (sparseArray != null) {
                        b.this.c(sparseArray);
                    } else {
                        return false;
                    }
                }
            }
            if (b.this.iUN != null) {
                b.this.iUN.cqr();
            }
            return true;
        }
    });

    public b(ReplyFragment replyFragment) {
        this.iUM = replyFragment;
        this.iUN = replyFragment.ckD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.iUM.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.iUM.ciU() != null && this.iUM.ciU().getPbData() != null && postData.cIt() != 1) {
            String ckU = this.iUM.ciU().ckU();
            String id = postData.getId();
            int chW = this.iUM.ciU().getPbData() != null ? this.iUM.ciU().getPbData().chW() : 0;
            PbActivity.a Fu = Fu(id);
            if (Fu != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.iUM.getPageContext().getPageActivity()).createSubPbActivityConfig(ckU, id, "pb", true, null, false, null, chW, postData.cpy(), this.iUM.ciU().getPbData().getAnti(), false, postData.azE() != null ? postData.azE().getIconInfo() : null).addBigImageData(Fu.iyY, Fu.iyZ, Fu.iza, Fu.index);
                addBigImageData.setKeyPageStartFrom(this.iUM.ciU().clG());
                addBigImageData.setFromFrsForumId(this.iUM.ciU().getFromForumId());
                addBigImageData.setKeyFromForumId(this.iUM.ciU().getForumId());
                addBigImageData.setBjhData(this.iUM.ciU().clc());
                this.iUM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a Fu(String str) {
        String str2;
        if (this.iUM.ciU() == null || this.iUM.ciU().getPbData() == null || this.iUM.ciU().getPbData().chM() == null || this.iUM.ciU().getPbData().chM().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.iUM.ciU().getPbData().chM().size()) {
                i = 0;
                break;
            } else if (str.equals(this.iUM.ciU().getPbData().chM().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.iUM.ciU().getPbData().chM().get(i);
        if (postData.cIv() == null || postData.cIv().aRf() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cIv().aRf().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.aRl() != null) {
                    str2 = next.aRl().aRz();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        g.a(postData, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bk(String str, int i) {
        TbRichText tbRichText = null;
        if (this.iUM.ciU() == null || this.iUM.ciU().getPbData() == null || str == null || i < 0) {
            return null;
        }
        f pbData = this.iUM.ciU().getPbData();
        if (pbData.chR() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.chR());
            tbRichText = b(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> chM = pbData.chM();
            c(pbData, chM);
            return b(chM, str, i);
        }
        return tbRichText;
    }

    private void c(f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.chV() != null && fVar.chV().ixt != null && (list = fVar.chV().ixt) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<PostData> it = arrayList.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            PostData postData = (PostData) it2.next();
                            if (postData != null && !TextUtils.isEmpty(next.getId()) && !TextUtils.isEmpty(postData.getId()) && next.getId().equals(postData.getId())) {
                                arrayList2.add(postData);
                            }
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    arrayList3.removeAll(arrayList2);
                }
                if (arrayList3.size() > 0) {
                    arrayList.addAll(arrayList3);
                }
            }
        }
    }

    private TbRichText b(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> aRf;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cIv = arrayList.get(i2).cIv();
            if (cIv != null && (aRf = cIv.aRf()) != null) {
                int size = aRf.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (aRf.get(i4) != null && aRf.get(i4).getType() == 8) {
                        i3++;
                        if (aRf.get(i4).aRl().aRz().equals(str) || aRf.get(i4).aRl().aRA().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = aRf.get(i4).aRl().getWidth() * equipmentDensity;
                            int height = aRf.get(i4).aRl().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.iDy = i4;
                            return cIv;
                        } else if (i3 <= i) {
                        }
                    }
                    i4++;
                    i3 = i3;
                }
                continue;
            }
        }
        return null;
    }

    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            f pbData = this.iUM.ciU().getPbData();
            TbRichText bk = bk(str, i);
            if (bk != null && (tbRichTextData = bk.aRf().get(this.iDy)) != null) {
                aVar.postId = String.valueOf(bk.getPostId());
                aVar.iyY = new ArrayList<>();
                aVar.iyZ = new ConcurrentHashMap<>();
                if (!tbRichTextData.aRl().aRx()) {
                    aVar.izb = false;
                    String b = g.b(tbRichTextData);
                    aVar.iyY.add(b);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((e) y.b(this.iUM.ckE()).l(e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalSize = d(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                    imageUrlData.isLongPic = f(tbRichTextData);
                    imageUrlData.postId = bk.getPostId();
                    imageUrlData.mIsReserver = this.iUM.ciU().clm();
                    imageUrlData.mIsSeeHost = this.iUM.ciU().getHostMode();
                    aVar.iyZ.put(b, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.chK() != null) {
                            aVar.threadId = pbData.chK().getId();
                        }
                        aVar.iza = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.izb = true;
                int size = pbData.chM().size();
                this.iDz = false;
                aVar.index = -1;
                int a = pbData.chR() != null ? a(pbData.chR().cIv(), bk, i, i, aVar.iyY, aVar.iyZ) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.chM().get(i2);
                    if (postData.getId() == null || pbData.chR() == null || pbData.chR().getId() == null || !postData.getId().equals(pbData.chR().getId())) {
                        a = a(postData.cIv(), bk, a, i, aVar.iyY, aVar.iyZ);
                    }
                }
                if (aVar.iyY.size() > 0) {
                    aVar.lastId = aVar.iyY.get(aVar.iyY.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.chK() != null) {
                        aVar.threadId = pbData.chK().getId();
                    }
                    aVar.iza = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo aRl;
        String str;
        if (tbRichText == tbRichText2) {
            this.iDz = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.aRf().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.aRf().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.aRl().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.aRl().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.aRl().aRx()) {
                        if (tbRichText == tbRichText2 && i8 <= i2) {
                            i4 = i7 - 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else if (tbRichTextData.getType() == 20) {
                        i3 = i8;
                        i4 = i7;
                    } else {
                        String b = g.b(tbRichTextData);
                        if (!TextUtils.isEmpty(b)) {
                            arrayList.add(b);
                            if (tbRichTextData != null && (aRl = tbRichTextData.aRl()) != null) {
                                String aRz = aRl.aRz();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = aRl.aRA();
                                } else {
                                    imageUrlData.urlType = ((e) y.b(this.iUM.ckE()).l(e.class)).isFromCDN() ? 17 : 18;
                                    str = aRz;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.iUM.ciU().ckU(), -1L);
                                imageUrlData.mIsReserver = this.iUM.ciU().clm();
                                imageUrlData.mIsSeeHost = this.iUM.ciU().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b, imageUrlData);
                                }
                            }
                        }
                        if (!this.iDz) {
                            i4 = i7 + 1;
                            i3 = i8;
                        }
                        i3 = i8;
                        i4 = i7;
                    }
                }
                i6++;
                i7 = i4;
                i5 = i3;
            }
            return i7;
        }
        return i;
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aRl() == null) {
            return null;
        }
        return tbRichTextData.aRl().aRC();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aRl() == null) {
            return 0L;
        }
        return tbRichTextData.aRl().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aRl() == null) {
            return false;
        }
        return tbRichTextData.aRl().aRD();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aRl() == null) {
            return false;
        }
        return tbRichTextData.aRl().aRE();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.dIi;
    }

    public com.baidu.tieba.pb.a.c cqT() {
        return this.dmm;
    }
}
