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
    public ReplyFragment jLV;
    public VideoPbFragment jLW;
    private int juG = 0;
    boolean juH = false;
    private final TbRichTextView.i emX = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r2v57, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            c cEE;
            try {
                an anVar = new an("c13398");
                anVar.cI("tid", b.this.jLV.cwA().cyx());
                anVar.cI("fid", b.this.jLV.cwA().getForumId());
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.af("obj_locate", 3);
                anVar.af("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(b.this.jLV.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.jLV.cwA().getPbData().cvP()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    int i2 = -1;
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bcg() != null) {
                            ArrayList<TbRichTextImageInfo> bcg = tbRichTextView.getRichText().bcg();
                            int i3 = 0;
                            while (i3 < bcg.size()) {
                                if (bcg.get(i3) != null) {
                                    arrayList.add(bcg.get(i3).getSrc());
                                    if (i2 == -1 && str != null && str.equals(bcg.get(i3).getSrc())) {
                                        i2 = i3;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bcg.get(i3).getSrc();
                                    imageUrlData.originalUrl = bcg.get(i3).getSrc();
                                    imageUrlData.isLongPic = bcg.get(i3).bcD();
                                    concurrentHashMap.put(bcg.get(i3).getSrc(), imageUrlData);
                                }
                                i3++;
                                i2 = i2;
                            }
                        }
                    }
                    ImageViewerConfig createConfig = new ImageViewerConfig(b.this.jLV.getPageContext().getPageActivity()).createConfig(arrayList, i2, "", "", "", false, "", b.this.jLV.cwA().cyO(), concurrentHashMap, true, false, z);
                    createConfig.getIntent().putExtra("from", "pb");
                    if (b.this.jLV.cwA() != null && b.this.jLV.cwA().getPbData() != null) {
                        createConfig.setThreadData(b.this.jLV.cwA().getPbData().cvr());
                    }
                    b.this.jLV.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar = new PbActivity.a();
                b.this.a(str, i, aVar);
                if (aVar.jqo) {
                    TbRichText bt = b.this.bt(str, i);
                    if (bt != null && b.this.juG >= 0 && b.this.juG < bt.bcf().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String b = f.b(bt.bcf().get(b.this.juG));
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= aVar.jql.size()) {
                                break;
                            } else if (!aVar.jql.get(i5).equals(b)) {
                                i4 = i5 + 1;
                            } else {
                                aVar.index = i5;
                                arrayList2.add(b);
                                break;
                            }
                        }
                        if (bt.getPostId() != 0 && (cEE = b.this.jLV.cEE()) != null) {
                            ArrayList<m> dataList = cEE.getDataList();
                            if (v.getCount(dataList) > 0) {
                                Iterator<m> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    m next = it.next();
                                    if ((next instanceof PostData) && bt.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.jLV.cwA().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!v.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar.jqm.get(str2));
                        }
                        ImageViewerConfig createConfig2 = new ImageViewerConfig(b.this.jLV.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jqn, aVar.lastId, b.this.jLV.cwA().cyO(), concurrentHashMap2, true, false, z);
                        createConfig2.getIntent().putExtra("from", "pb");
                        createConfig2.setPostId(aVar.postId);
                        if (b.this.jLV.cwA() != null && b.this.jLV.cwA().getPbData() != null) {
                            createConfig2.setThreadData(b.this.jLV.cwA().getPbData().cvr());
                        }
                        b.this.jLV.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(v.getItem(aVar.jql, 0));
                ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                if (!v.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar.jqm.get(str3));
                }
                ImageViewerConfig createConfig3 = new ImageViewerConfig(b.this.jLV.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jqn, aVar.jql.get(0), b.this.jLV.cwA().cyO(), concurrentHashMap3, true, false, z);
                createConfig3.getIntent().putExtra("from", "pb");
                createConfig3.setIsCanDrag(false);
                createConfig3.setPostId(aVar.postId);
                if (b.this.jLV.cwA() != null && b.this.jLV.cwA().getPbData() != null) {
                    createConfig3.setThreadData(b.this.jLV.cwA().getPbData().cvr());
                }
                b.this.jLV.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private com.baidu.tieba.pb.a.c dRm = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.jLW == null || !b.this.jLW.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.jLW != null && b.this.jLW.cB(view)) {
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
            if (b.this.jLW != null) {
                b.this.jLW.cDQ();
            }
            return true;
        }
    });

    public b(ReplyFragment replyFragment) {
        this.jLV = replyFragment;
        this.jLW = replyFragment.cyg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.jLV.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.jLV.cwA() != null && this.jLV.cwA().getPbData() != null && postData.cWo() != 1) {
            String cyx = this.jLV.cwA().cyx();
            String id = postData.getId();
            int cvD = this.jLV.cwA().getPbData() != null ? this.jLV.cwA().getPbData().cvD() : 0;
            PbActivity.a HD = HD(id);
            if (HD != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.jLV.getPageContext().getPageActivity()).createSubPbActivityConfig(cyx, id, "pb", true, null, false, null, cvD, postData.cCY(), this.jLV.cwA().getPbData().getAnti(), false, postData.aKC() != null ? postData.aKC().getIconInfo() : null).addBigImageData(HD.jql, HD.jqm, HD.jqn, HD.index);
                addBigImageData.setKeyPageStartFrom(this.jLV.cwA().czg());
                addBigImageData.setFromFrsForumId(this.jLV.cwA().getFromForumId());
                addBigImageData.setKeyFromForumId(this.jLV.cwA().getForumId());
                addBigImageData.setBjhData(this.jLV.cwA().cyF());
                this.jLV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a HD(String str) {
        String str2;
        if (this.jLV.cwA() == null || this.jLV.cwA().getPbData() == null || this.jLV.cwA().getPbData().cvt() == null || this.jLV.cwA().getPbData().cvt().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.jLV.cwA().getPbData().cvt().size()) {
                i = 0;
                break;
            } else if (str.equals(this.jLV.cwA().getPbData().cvt().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.jLV.cwA().getPbData().cvt().get(i);
        if (postData.cWq() == null || postData.cWq().bcf() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cWq().bcf().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bcl() != null) {
                    str2 = next.bcl().bcy();
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
        if (this.jLV.cwA() == null || this.jLV.cwA().getPbData() == null || str == null || i < 0) {
            return null;
        }
        e pbData = this.jLV.cwA().getPbData();
        if (pbData.cvy() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cvy());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cvt = pbData.cvt();
            c(pbData, cvt);
            return c(cvt, str, i);
        }
        return tbRichText;
    }

    private void c(e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.cvC() != null && eVar.cvC().joP != null && (list = eVar.cvC().joP) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bcf;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cWq = arrayList.get(i2).cWq();
            if (cWq != null && (bcf = cWq.bcf()) != null) {
                int size = bcf.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bcf.get(i4) != null && bcf.get(i4).getType() == 8) {
                        i3++;
                        if (bcf.get(i4).bcl().bcy().equals(str) || bcf.get(i4).bcl().bcz().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bcf.get(i4).bcl().getWidth() * equipmentDensity;
                            int height = bcf.get(i4).bcl().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.juG = i4;
                            return cWq;
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
            e pbData = this.jLV.cwA().getPbData();
            TbRichText bt = bt(str, i);
            if (bt != null && (tbRichTextData = bt.bcf().get(this.juG)) != null) {
                aVar.postId = String.valueOf(bt.getPostId());
                aVar.jql = new ArrayList<>();
                aVar.jqm = new ConcurrentHashMap<>();
                if (!tbRichTextData.bcl().bcw()) {
                    aVar.jqo = false;
                    String b = f.b(tbRichTextData);
                    aVar.jql.add(b);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((com.baidu.tieba.pb.videopb.e) y.b(this.jLV.cyh()).l(com.baidu.tieba.pb.videopb.e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalSize = d(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                    imageUrlData.isLongPic = f(tbRichTextData);
                    imageUrlData.postId = bt.getPostId();
                    imageUrlData.mIsReserver = this.jLV.cwA().cyO();
                    imageUrlData.mIsSeeHost = this.jLV.cwA().getHostMode();
                    aVar.jqm.put(b, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cvr() != null) {
                            aVar.threadId = pbData.cvr().getId();
                        }
                        aVar.jqn = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.jqo = true;
                int size = pbData.cvt().size();
                this.juH = false;
                aVar.index = -1;
                int a = pbData.cvy() != null ? a(pbData.cvy().cWq(), bt, i, i, aVar.jql, aVar.jqm) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cvt().get(i2);
                    if (postData.getId() == null || pbData.cvy() == null || pbData.cvy().getId() == null || !postData.getId().equals(pbData.cvy().getId())) {
                        a = a(postData.cWq(), bt, a, i, aVar.jql, aVar.jqm);
                    }
                }
                if (aVar.jql.size() > 0) {
                    aVar.lastId = aVar.jql.get(aVar.jql.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cvr() != null) {
                        aVar.threadId = pbData.cvr().getId();
                    }
                    aVar.jqn = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bcl;
        String str;
        if (tbRichText == tbRichText2) {
            this.juH = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bcf().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bcf().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bcl().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bcl().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bcl().bcw()) {
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
                            if (tbRichTextData != null && (bcl = tbRichTextData.bcl()) != null) {
                                String bcy = bcl.bcy();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bcl.bcz();
                                } else {
                                    imageUrlData.urlType = ((com.baidu.tieba.pb.videopb.e) y.b(this.jLV.cyh()).l(com.baidu.tieba.pb.videopb.e.class)).isFromCDN() ? 17 : 18;
                                    str = bcy;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.jLV.cwA().cyx(), -1L);
                                imageUrlData.mIsReserver = this.jLV.cwA().cyO();
                                imageUrlData.mIsSeeHost = this.jLV.cwA().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b, imageUrlData);
                                }
                            }
                        }
                        if (!this.juH) {
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
        if (tbRichTextData == null || tbRichTextData.bcl() == null) {
            return null;
        }
        return tbRichTextData.bcl().bcB();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bcl() == null) {
            return 0L;
        }
        return tbRichTextData.bcl().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bcl() == null) {
            return false;
        }
        return tbRichTextData.bcl().bcC();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bcl() == null) {
            return false;
        }
        return tbRichTextData.bcl().bcD();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.emX;
    }

    public com.baidu.tieba.pb.a.c cEw() {
        return this.dRm;
    }
}
