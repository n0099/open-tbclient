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
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.c;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class b {
    public ReplyFragment jLR;
    public VideoPbFragment jLS;
    private int juC = 0;
    boolean juD = false;
    private final TbRichTextView.i emS = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r2v57, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            c cEH;
            try {
                an anVar = new an("c13398");
                anVar.cI("tid", b.this.jLR.cwD().cyA());
                anVar.cI("fid", b.this.jLR.cwD().getForumId());
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.af("obj_locate", 3);
                anVar.af("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(b.this.jLR.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.jLR.cwD().getPbData().cvS()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    int i2 = -1;
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bci() != null) {
                            ArrayList<TbRichTextImageInfo> bci = tbRichTextView.getRichText().bci();
                            int i3 = 0;
                            while (i3 < bci.size()) {
                                if (bci.get(i3) != null) {
                                    arrayList.add(bci.get(i3).getSrc());
                                    if (i2 == -1 && str != null && str.equals(bci.get(i3).getSrc())) {
                                        i2 = i3;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bci.get(i3).getSrc();
                                    imageUrlData.originalUrl = bci.get(i3).getSrc();
                                    imageUrlData.isLongPic = bci.get(i3).bcF();
                                    concurrentHashMap.put(bci.get(i3).getSrc(), imageUrlData);
                                }
                                i3++;
                                i2 = i2;
                            }
                        }
                    }
                    ImageViewerConfig createConfig = new ImageViewerConfig(b.this.jLR.getPageContext().getPageActivity()).createConfig(arrayList, i2, "", "", "", false, "", b.this.jLR.cwD().cyR(), concurrentHashMap, true, false, z);
                    createConfig.getIntent().putExtra("from", "pb");
                    if (b.this.jLR.cwD() != null && b.this.jLR.cwD().getPbData() != null) {
                        createConfig.setThreadData(b.this.jLR.cwD().getPbData().cvu());
                    }
                    b.this.jLR.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar = new PbActivity.a();
                b.this.a(str, i, aVar);
                if (aVar.jqk) {
                    TbRichText bt = b.this.bt(str, i);
                    if (bt != null && b.this.juC >= 0 && b.this.juC < bt.bch().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String b = f.b(bt.bch().get(b.this.juC));
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= aVar.jqh.size()) {
                                break;
                            } else if (!aVar.jqh.get(i5).equals(b)) {
                                i4 = i5 + 1;
                            } else {
                                aVar.index = i5;
                                arrayList2.add(b);
                                break;
                            }
                        }
                        if (bt.getPostId() != 0 && (cEH = b.this.jLR.cEH()) != null) {
                            ArrayList<m> dataList = cEH.getDataList();
                            if (v.getCount(dataList) > 0) {
                                Iterator<m> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    m next = it.next();
                                    if ((next instanceof PostData) && bt.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.jLR.cwD().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!v.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar.jqi.get(str2));
                        }
                        ImageViewerConfig createConfig2 = new ImageViewerConfig(b.this.jLR.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jqj, aVar.lastId, b.this.jLR.cwD().cyR(), concurrentHashMap2, true, false, z);
                        createConfig2.getIntent().putExtra("from", "pb");
                        createConfig2.setPostId(aVar.postId);
                        if (b.this.jLR.cwD() != null && b.this.jLR.cwD().getPbData() != null) {
                            createConfig2.setThreadData(b.this.jLR.cwD().getPbData().cvu());
                        }
                        b.this.jLR.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(v.getItem(aVar.jqh, 0));
                ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                if (!v.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar.jqi.get(str3));
                }
                ImageViewerConfig createConfig3 = new ImageViewerConfig(b.this.jLR.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jqj, aVar.jqh.get(0), b.this.jLR.cwD().cyR(), concurrentHashMap3, true, false, z);
                createConfig3.getIntent().putExtra("from", "pb");
                createConfig3.setIsCanDrag(false);
                createConfig3.setPostId(aVar.postId);
                if (b.this.jLR.cwD() != null && b.this.jLR.cwD().getPbData() != null) {
                    createConfig3.setThreadData(b.this.jLR.cwD().getPbData().cvu());
                }
                b.this.jLR.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private com.baidu.tieba.pb.a.c dRh = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.jLS == null || !b.this.jLS.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.jLS != null && b.this.jLS.cB(view)) {
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
            if (b.this.jLS != null) {
                b.this.jLS.cDT();
            }
            return true;
        }
    });

    public b(ReplyFragment replyFragment) {
        this.jLR = replyFragment;
        this.jLS = replyFragment.cyj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.jLR.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.jLR.cwD() != null && this.jLR.cwD().getPbData() != null && postData.cWr() != 1) {
            String cyA = this.jLR.cwD().cyA();
            String id = postData.getId();
            int cvG = this.jLR.cwD().getPbData() != null ? this.jLR.cwD().getPbData().cvG() : 0;
            PbActivity.a HA = HA(id);
            if (HA != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.jLR.getPageContext().getPageActivity()).createSubPbActivityConfig(cyA, id, "pb", true, null, false, null, cvG, postData.cDb(), this.jLR.cwD().getPbData().getAnti(), false, postData.aKE() != null ? postData.aKE().getIconInfo() : null).addBigImageData(HA.jqh, HA.jqi, HA.jqj, HA.index);
                addBigImageData.setKeyPageStartFrom(this.jLR.cwD().czj());
                addBigImageData.setFromFrsForumId(this.jLR.cwD().getFromForumId());
                addBigImageData.setKeyFromForumId(this.jLR.cwD().getForumId());
                addBigImageData.setBjhData(this.jLR.cwD().cyI());
                this.jLR.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a HA(String str) {
        String str2;
        if (this.jLR.cwD() == null || this.jLR.cwD().getPbData() == null || this.jLR.cwD().getPbData().cvw() == null || this.jLR.cwD().getPbData().cvw().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.jLR.cwD().getPbData().cvw().size()) {
                i = 0;
                break;
            } else if (str.equals(this.jLR.cwD().getPbData().cvw().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.jLR.cwD().getPbData().cvw().get(i);
        if (postData.cWt() == null || postData.cWt().bch() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cWt().bch().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bcn() != null) {
                    str2 = next.bcn().bcA();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        f.a(postData, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bt(String str, int i) {
        TbRichText tbRichText = null;
        if (this.jLR.cwD() == null || this.jLR.cwD().getPbData() == null || str == null || i < 0) {
            return null;
        }
        e pbData = this.jLR.cwD().getPbData();
        if (pbData.cvB() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cvB());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cvw = pbData.cvw();
            c(pbData, cvw);
            return c(cvw, str, i);
        }
        return tbRichText;
    }

    private void c(e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.cvF() != null && eVar.cvF().joL != null && (list = eVar.cvF().joL) != null && arrayList != null) {
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

    private TbRichText c(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> bch;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cWt = arrayList.get(i2).cWt();
            if (cWt != null && (bch = cWt.bch()) != null) {
                int size = bch.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bch.get(i4) != null && bch.get(i4).getType() == 8) {
                        i3++;
                        if (bch.get(i4).bcn().bcA().equals(str) || bch.get(i4).bcn().bcB().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bch.get(i4).bcn().getWidth() * equipmentDensity;
                            int height = bch.get(i4).bcn().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.juC = i4;
                            return cWt;
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
            e pbData = this.jLR.cwD().getPbData();
            TbRichText bt = bt(str, i);
            if (bt != null && (tbRichTextData = bt.bch().get(this.juC)) != null) {
                aVar.postId = String.valueOf(bt.getPostId());
                aVar.jqh = new ArrayList<>();
                aVar.jqi = new ConcurrentHashMap<>();
                if (!tbRichTextData.bcn().bcy()) {
                    aVar.jqk = false;
                    String b = f.b(tbRichTextData);
                    aVar.jqh.add(b);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((com.baidu.tieba.pb.videopb.e) y.b(this.jLR.cyk()).l(com.baidu.tieba.pb.videopb.e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalSize = d(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                    imageUrlData.isLongPic = f(tbRichTextData);
                    imageUrlData.postId = bt.getPostId();
                    imageUrlData.mIsReserver = this.jLR.cwD().cyR();
                    imageUrlData.mIsSeeHost = this.jLR.cwD().getHostMode();
                    aVar.jqi.put(b, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cvu() != null) {
                            aVar.threadId = pbData.cvu().getId();
                        }
                        aVar.jqj = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.jqk = true;
                int size = pbData.cvw().size();
                this.juD = false;
                aVar.index = -1;
                int a = pbData.cvB() != null ? a(pbData.cvB().cWt(), bt, i, i, aVar.jqh, aVar.jqi) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cvw().get(i2);
                    if (postData.getId() == null || pbData.cvB() == null || pbData.cvB().getId() == null || !postData.getId().equals(pbData.cvB().getId())) {
                        a = a(postData.cWt(), bt, a, i, aVar.jqh, aVar.jqi);
                    }
                }
                if (aVar.jqh.size() > 0) {
                    aVar.lastId = aVar.jqh.get(aVar.jqh.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cvu() != null) {
                        aVar.threadId = pbData.cvu().getId();
                    }
                    aVar.jqj = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bcn;
        String str;
        if (tbRichText == tbRichText2) {
            this.juD = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bch().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bch().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bcn().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bcn().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bcn().bcy()) {
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
                        String b = f.b(tbRichTextData);
                        if (!TextUtils.isEmpty(b)) {
                            arrayList.add(b);
                            if (tbRichTextData != null && (bcn = tbRichTextData.bcn()) != null) {
                                String bcA = bcn.bcA();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bcn.bcB();
                                } else {
                                    imageUrlData.urlType = ((com.baidu.tieba.pb.videopb.e) y.b(this.jLR.cyk()).l(com.baidu.tieba.pb.videopb.e.class)).isFromCDN() ? 17 : 18;
                                    str = bcA;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.jLR.cwD().cyA(), -1L);
                                imageUrlData.mIsReserver = this.jLR.cwD().cyR();
                                imageUrlData.mIsSeeHost = this.jLR.cwD().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b, imageUrlData);
                                }
                            }
                        }
                        if (!this.juD) {
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
        if (tbRichTextData == null || tbRichTextData.bcn() == null) {
            return null;
        }
        return tbRichTextData.bcn().bcD();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bcn() == null) {
            return 0L;
        }
        return tbRichTextData.bcn().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bcn() == null) {
            return false;
        }
        return tbRichTextData.bcn().bcE();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bcn() == null) {
            return false;
        }
        return tbRichTextData.bcn().bcF();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.emS;
    }

    public com.baidu.tieba.pb.a.c cEz() {
        return this.dRh;
    }
}
