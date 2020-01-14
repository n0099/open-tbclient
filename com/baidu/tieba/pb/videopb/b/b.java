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
/* loaded from: classes7.dex */
public class b {
    public ReplyFragment iYu;
    public VideoPbFragment iYv;
    private int iHc = 0;
    boolean iHd = false;
    private final TbRichTextView.i dIr = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r2v57, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            c csk;
            try {
                an anVar = new an("c13398");
                anVar.cp("tid", b.this.iYu.ckc().cmc());
                anVar.cp("fid", b.this.iYu.ckc().getForumId());
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.Z("obj_locate", 3);
                anVar.Z("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(b.this.iYu.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.iYu.ckc().getPbData().cjs()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    int i2 = -1;
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().aRA() != null) {
                            ArrayList<TbRichTextImageInfo> aRA = tbRichTextView.getRichText().aRA();
                            int i3 = 0;
                            while (i3 < aRA.size()) {
                                if (aRA.get(i3) != null) {
                                    arrayList.add(aRA.get(i3).getSrc());
                                    if (i2 == -1 && str != null && str.equals(aRA.get(i3).getSrc())) {
                                        i2 = i3;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = aRA.get(i3).getSrc();
                                    imageUrlData.originalUrl = aRA.get(i3).getSrc();
                                    imageUrlData.isLongPic = aRA.get(i3).aRY();
                                    concurrentHashMap.put(aRA.get(i3).getSrc(), imageUrlData);
                                }
                                i3++;
                                i2 = i2;
                            }
                        }
                    }
                    ImageViewerConfig createConfig = new ImageViewerConfig(b.this.iYu.getPageContext().getPageActivity()).createConfig(arrayList, i2, "", "", "", false, "", b.this.iYu.ckc().cmu(), concurrentHashMap, true, false, z);
                    createConfig.getIntent().putExtra("from", "pb");
                    if (b.this.iYu.ckc() != null && b.this.iYu.ckc().getPbData() != null) {
                        createConfig.setThreadData(b.this.iYu.ckc().getPbData().ciS());
                    }
                    b.this.iYu.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar = new PbActivity.a();
                b.this.a(str, i, aVar);
                if (aVar.iCF) {
                    TbRichText bl = b.this.bl(str, i);
                    if (bl != null && b.this.iHc >= 0 && b.this.iHc < bl.aRz().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String b = g.b(bl.aRz().get(b.this.iHc));
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= aVar.iCC.size()) {
                                break;
                            } else if (!aVar.iCC.get(i5).equals(b)) {
                                i4 = i5 + 1;
                            } else {
                                aVar.index = i5;
                                arrayList2.add(b);
                                break;
                            }
                        }
                        if (bl.getPostId() != 0 && (csk = b.this.iYu.csk()) != null) {
                            ArrayList<m> dataList = csk.getDataList();
                            if (v.getCount(dataList) > 0) {
                                Iterator<m> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    m next = it.next();
                                    if ((next instanceof PostData) && bl.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.iYu.ckc().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!v.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar.iCD.get(str2));
                        }
                        ImageViewerConfig createConfig2 = new ImageViewerConfig(b.this.iYu.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iCE, aVar.lastId, b.this.iYu.ckc().cmu(), concurrentHashMap2, true, false, z);
                        createConfig2.getIntent().putExtra("from", "pb");
                        createConfig2.setPostId(aVar.postId);
                        if (b.this.iYu.ckc() != null && b.this.iYu.ckc().getPbData() != null) {
                            createConfig2.setThreadData(b.this.iYu.ckc().getPbData().ciS());
                        }
                        b.this.iYu.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(v.getItem(aVar.iCC, 0));
                ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                if (!v.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar.iCD.get(str3));
                }
                ImageViewerConfig createConfig3 = new ImageViewerConfig(b.this.iYu.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iCE, aVar.iCC.get(0), b.this.iYu.ckc().cmu(), concurrentHashMap3, true, false, z);
                createConfig3.getIntent().putExtra("from", "pb");
                createConfig3.setIsCanDrag(false);
                createConfig3.setPostId(aVar.postId);
                if (b.this.iYu.ckc() != null && b.this.iYu.ckc().getPbData() != null) {
                    createConfig3.setThreadData(b.this.iYu.ckc().getPbData().ciS());
                }
                b.this.iYu.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private com.baidu.tieba.pb.a.c dmA = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.iYv == null || !b.this.iYv.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.iYv != null && b.this.iYv.cu(view)) {
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
            if (b.this.iYv != null) {
                b.this.iYv.crA();
            }
            return true;
        }
    });

    public b(ReplyFragment replyFragment) {
        this.iYu = replyFragment;
        this.iYv = replyFragment.clL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.iYu.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.iYu.ckc() != null && this.iYu.ckc().getPbData() != null && postData.cJz() != 1) {
            String cmc = this.iYu.ckc().cmc();
            String id = postData.getId();
            int cje = this.iYu.ckc().getPbData() != null ? this.iYu.ckc().getPbData().cje() : 0;
            PbActivity.a FE = FE(id);
            if (FE != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.iYu.getPageContext().getPageActivity()).createSubPbActivityConfig(cmc, id, "pb", true, null, false, null, cje, postData.cqG(), this.iYu.ckc().getPbData().getAnti(), false, postData.azX() != null ? postData.azX().getIconInfo() : null).addBigImageData(FE.iCC, FE.iCD, FE.iCE, FE.index);
                addBigImageData.setKeyPageStartFrom(this.iYu.ckc().cmO());
                addBigImageData.setFromFrsForumId(this.iYu.ckc().getFromForumId());
                addBigImageData.setKeyFromForumId(this.iYu.ckc().getForumId());
                addBigImageData.setBjhData(this.iYu.ckc().cmk());
                this.iYu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a FE(String str) {
        String str2;
        if (this.iYu.ckc() == null || this.iYu.ckc().getPbData() == null || this.iYu.ckc().getPbData().ciU() == null || this.iYu.ckc().getPbData().ciU().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.iYu.ckc().getPbData().ciU().size()) {
                i = 0;
                break;
            } else if (str.equals(this.iYu.ckc().getPbData().ciU().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.iYu.ckc().getPbData().ciU().get(i);
        if (postData.cJB() == null || postData.cJB().aRz() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cJB().aRz().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.aRF() != null) {
                    str2 = next.aRF().aRT();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        g.a(postData, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bl(String str, int i) {
        TbRichText tbRichText = null;
        if (this.iYu.ckc() == null || this.iYu.ckc().getPbData() == null || str == null || i < 0) {
            return null;
        }
        f pbData = this.iYu.ckc().getPbData();
        if (pbData.ciZ() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.ciZ());
            tbRichText = b(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> ciU = pbData.ciU();
            c(pbData, ciU);
            return b(ciU, str, i);
        }
        return tbRichText;
    }

    private void c(f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.cjd() != null && fVar.cjd().iAX != null && (list = fVar.cjd().iAX) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> aRz;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cJB = arrayList.get(i2).cJB();
            if (cJB != null && (aRz = cJB.aRz()) != null) {
                int size = aRz.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (aRz.get(i4) != null && aRz.get(i4).getType() == 8) {
                        i3++;
                        if (aRz.get(i4).aRF().aRT().equals(str) || aRz.get(i4).aRF().aRU().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = aRz.get(i4).aRF().getWidth() * equipmentDensity;
                            int height = aRz.get(i4).aRF().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.iHc = i4;
                            return cJB;
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
            f pbData = this.iYu.ckc().getPbData();
            TbRichText bl = bl(str, i);
            if (bl != null && (tbRichTextData = bl.aRz().get(this.iHc)) != null) {
                aVar.postId = String.valueOf(bl.getPostId());
                aVar.iCC = new ArrayList<>();
                aVar.iCD = new ConcurrentHashMap<>();
                if (!tbRichTextData.aRF().aRR()) {
                    aVar.iCF = false;
                    String b = g.b(tbRichTextData);
                    aVar.iCC.add(b);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((e) y.b(this.iYu.clM()).l(e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalSize = d(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                    imageUrlData.isLongPic = f(tbRichTextData);
                    imageUrlData.postId = bl.getPostId();
                    imageUrlData.mIsReserver = this.iYu.ckc().cmu();
                    imageUrlData.mIsSeeHost = this.iYu.ckc().getHostMode();
                    aVar.iCD.put(b, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.ciS() != null) {
                            aVar.threadId = pbData.ciS().getId();
                        }
                        aVar.iCE = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.iCF = true;
                int size = pbData.ciU().size();
                this.iHd = false;
                aVar.index = -1;
                int a = pbData.ciZ() != null ? a(pbData.ciZ().cJB(), bl, i, i, aVar.iCC, aVar.iCD) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.ciU().get(i2);
                    if (postData.getId() == null || pbData.ciZ() == null || pbData.ciZ().getId() == null || !postData.getId().equals(pbData.ciZ().getId())) {
                        a = a(postData.cJB(), bl, a, i, aVar.iCC, aVar.iCD);
                    }
                }
                if (aVar.iCC.size() > 0) {
                    aVar.lastId = aVar.iCC.get(aVar.iCC.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.ciS() != null) {
                        aVar.threadId = pbData.ciS().getId();
                    }
                    aVar.iCE = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo aRF;
        String str;
        if (tbRichText == tbRichText2) {
            this.iHd = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.aRz().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.aRz().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.aRF().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.aRF().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.aRF().aRR()) {
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
                            if (tbRichTextData != null && (aRF = tbRichTextData.aRF()) != null) {
                                String aRT = aRF.aRT();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = aRF.aRU();
                                } else {
                                    imageUrlData.urlType = ((e) y.b(this.iYu.clM()).l(e.class)).isFromCDN() ? 17 : 18;
                                    str = aRT;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.iYu.ckc().cmc(), -1L);
                                imageUrlData.mIsReserver = this.iYu.ckc().cmu();
                                imageUrlData.mIsSeeHost = this.iYu.ckc().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b, imageUrlData);
                                }
                            }
                        }
                        if (!this.iHd) {
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
        if (tbRichTextData == null || tbRichTextData.aRF() == null) {
            return null;
        }
        return tbRichTextData.aRF().aRW();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aRF() == null) {
            return 0L;
        }
        return tbRichTextData.aRF().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aRF() == null) {
            return false;
        }
        return tbRichTextData.aRF().aRX();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aRF() == null) {
            return false;
        }
        return tbRichTextData.aRF().aRY();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.dIr;
    }

    public com.baidu.tieba.pb.a.c csc() {
        return this.dmA;
    }
}
