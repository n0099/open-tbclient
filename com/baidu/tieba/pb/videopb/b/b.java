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
    public ReplyFragment jaj;
    public VideoPbFragment jak;
    private int iIT = 0;
    boolean iIU = false;
    private final TbRichTextView.i dMK = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r2v57, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            c ctG;
            try {
                an anVar = new an("c13398");
                anVar.cy("tid", b.this.jaj.clC().cnz());
                anVar.cy("fid", b.this.jaj.clC().getForumId());
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.X("obj_locate", 3);
                anVar.X("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(b.this.jaj.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.jaj.clC().getPbData().ckT()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    int i2 = -1;
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().aTU() != null) {
                            ArrayList<TbRichTextImageInfo> aTU = tbRichTextView.getRichText().aTU();
                            int i3 = 0;
                            while (i3 < aTU.size()) {
                                if (aTU.get(i3) != null) {
                                    arrayList.add(aTU.get(i3).getSrc());
                                    if (i2 == -1 && str != null && str.equals(aTU.get(i3).getSrc())) {
                                        i2 = i3;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = aTU.get(i3).getSrc();
                                    imageUrlData.originalUrl = aTU.get(i3).getSrc();
                                    imageUrlData.isLongPic = aTU.get(i3).aUr();
                                    concurrentHashMap.put(aTU.get(i3).getSrc(), imageUrlData);
                                }
                                i3++;
                                i2 = i2;
                            }
                        }
                    }
                    ImageViewerConfig createConfig = new ImageViewerConfig(b.this.jaj.getPageContext().getPageActivity()).createConfig(arrayList, i2, "", "", "", false, "", b.this.jaj.clC().cnQ(), concurrentHashMap, true, false, z);
                    createConfig.getIntent().putExtra("from", "pb");
                    if (b.this.jaj.clC() != null && b.this.jaj.clC().getPbData() != null) {
                        createConfig.setThreadData(b.this.jaj.clC().getPbData().ckv());
                    }
                    b.this.jaj.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar = new PbActivity.a();
                b.this.a(str, i, aVar);
                if (aVar.iEC) {
                    TbRichText bj = b.this.bj(str, i);
                    if (bj != null && b.this.iIT >= 0 && b.this.iIT < bj.aTT().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String b = f.b(bj.aTT().get(b.this.iIT));
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= aVar.iEz.size()) {
                                break;
                            } else if (!aVar.iEz.get(i5).equals(b)) {
                                i4 = i5 + 1;
                            } else {
                                aVar.index = i5;
                                arrayList2.add(b);
                                break;
                            }
                        }
                        if (bj.getPostId() != 0 && (ctG = b.this.jaj.ctG()) != null) {
                            ArrayList<m> dataList = ctG.getDataList();
                            if (v.getCount(dataList) > 0) {
                                Iterator<m> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    m next = it.next();
                                    if ((next instanceof PostData) && bj.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.jaj.clC().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!v.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar.iEA.get(str2));
                        }
                        ImageViewerConfig createConfig2 = new ImageViewerConfig(b.this.jaj.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iEB, aVar.lastId, b.this.jaj.clC().cnQ(), concurrentHashMap2, true, false, z);
                        createConfig2.getIntent().putExtra("from", "pb");
                        createConfig2.setPostId(aVar.postId);
                        if (b.this.jaj.clC() != null && b.this.jaj.clC().getPbData() != null) {
                            createConfig2.setThreadData(b.this.jaj.clC().getPbData().ckv());
                        }
                        b.this.jaj.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(v.getItem(aVar.iEz, 0));
                ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                if (!v.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar.iEA.get(str3));
                }
                ImageViewerConfig createConfig3 = new ImageViewerConfig(b.this.jaj.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iEB, aVar.iEz.get(0), b.this.jaj.clC().cnQ(), concurrentHashMap3, true, false, z);
                createConfig3.getIntent().putExtra("from", "pb");
                createConfig3.setIsCanDrag(false);
                createConfig3.setPostId(aVar.postId);
                if (b.this.jaj.clC() != null && b.this.jaj.clC().getPbData() != null) {
                    createConfig3.setThreadData(b.this.jaj.clC().getPbData().ckv());
                }
                b.this.jaj.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private com.baidu.tieba.pb.a.c dqX = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.jak == null || !b.this.jak.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.jak != null && b.this.jak.ct(view)) {
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
            if (b.this.jak != null) {
                b.this.jak.csS();
            }
            return true;
        }
    });

    public b(ReplyFragment replyFragment) {
        this.jaj = replyFragment;
        this.jak = replyFragment.cni();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.jaj.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.jaj.clC() != null && this.jaj.clC().getPbData() != null && postData.cLb() != 1) {
            String cnz = this.jaj.clC().cnz();
            String id = postData.getId();
            int ckH = this.jaj.clC().getPbData() != null ? this.jaj.clC().getPbData().ckH() : 0;
            PbActivity.a FT = FT(id);
            if (FT != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.jaj.getPageContext().getPageActivity()).createSubPbActivityConfig(cnz, id, "pb", true, null, false, null, ckH, postData.csa(), this.jaj.clC().getPbData().getAnti(), false, postData.aCo() != null ? postData.aCo().getIconInfo() : null).addBigImageData(FT.iEz, FT.iEA, FT.iEB, FT.index);
                addBigImageData.setKeyPageStartFrom(this.jaj.clC().coi());
                addBigImageData.setFromFrsForumId(this.jaj.clC().getFromForumId());
                addBigImageData.setKeyFromForumId(this.jaj.clC().getForumId());
                addBigImageData.setBjhData(this.jaj.clC().cnH());
                this.jaj.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a FT(String str) {
        String str2;
        if (this.jaj.clC() == null || this.jaj.clC().getPbData() == null || this.jaj.clC().getPbData().ckx() == null || this.jaj.clC().getPbData().ckx().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.jaj.clC().getPbData().ckx().size()) {
                i = 0;
                break;
            } else if (str.equals(this.jaj.clC().getPbData().ckx().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.jaj.clC().getPbData().ckx().get(i);
        if (postData.cLd() == null || postData.cLd().aTT() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cLd().aTT().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.aTZ() != null) {
                    str2 = next.aTZ().aUm();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        f.a(postData, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bj(String str, int i) {
        TbRichText tbRichText = null;
        if (this.jaj.clC() == null || this.jaj.clC().getPbData() == null || str == null || i < 0) {
            return null;
        }
        e pbData = this.jaj.clC().getPbData();
        if (pbData.ckC() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.ckC());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> ckx = pbData.ckx();
            c(pbData, ckx);
            return c(ckx, str, i);
        }
        return tbRichText;
    }

    private void c(e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.ckG() != null && eVar.ckG().iDe != null && (list = eVar.ckG().iDe) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> aTT;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cLd = arrayList.get(i2).cLd();
            if (cLd != null && (aTT = cLd.aTT()) != null) {
                int size = aTT.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (aTT.get(i4) != null && aTT.get(i4).getType() == 8) {
                        i3++;
                        if (aTT.get(i4).aTZ().aUm().equals(str) || aTT.get(i4).aTZ().aUn().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = aTT.get(i4).aTZ().getWidth() * equipmentDensity;
                            int height = aTT.get(i4).aTZ().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.iIT = i4;
                            return cLd;
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
            e pbData = this.jaj.clC().getPbData();
            TbRichText bj = bj(str, i);
            if (bj != null && (tbRichTextData = bj.aTT().get(this.iIT)) != null) {
                aVar.postId = String.valueOf(bj.getPostId());
                aVar.iEz = new ArrayList<>();
                aVar.iEA = new ConcurrentHashMap<>();
                if (!tbRichTextData.aTZ().aUk()) {
                    aVar.iEC = false;
                    String b = f.b(tbRichTextData);
                    aVar.iEz.add(b);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((com.baidu.tieba.pb.videopb.e) y.b(this.jaj.cnj()).l(com.baidu.tieba.pb.videopb.e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalSize = d(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                    imageUrlData.isLongPic = f(tbRichTextData);
                    imageUrlData.postId = bj.getPostId();
                    imageUrlData.mIsReserver = this.jaj.clC().cnQ();
                    imageUrlData.mIsSeeHost = this.jaj.clC().getHostMode();
                    aVar.iEA.put(b, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.ckv() != null) {
                            aVar.threadId = pbData.ckv().getId();
                        }
                        aVar.iEB = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.iEC = true;
                int size = pbData.ckx().size();
                this.iIU = false;
                aVar.index = -1;
                int a = pbData.ckC() != null ? a(pbData.ckC().cLd(), bj, i, i, aVar.iEz, aVar.iEA) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.ckx().get(i2);
                    if (postData.getId() == null || pbData.ckC() == null || pbData.ckC().getId() == null || !postData.getId().equals(pbData.ckC().getId())) {
                        a = a(postData.cLd(), bj, a, i, aVar.iEz, aVar.iEA);
                    }
                }
                if (aVar.iEz.size() > 0) {
                    aVar.lastId = aVar.iEz.get(aVar.iEz.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.ckv() != null) {
                        aVar.threadId = pbData.ckv().getId();
                    }
                    aVar.iEB = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo aTZ;
        String str;
        if (tbRichText == tbRichText2) {
            this.iIU = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.aTT().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.aTT().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.aTZ().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.aTZ().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.aTZ().aUk()) {
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
                            if (tbRichTextData != null && (aTZ = tbRichTextData.aTZ()) != null) {
                                String aUm = aTZ.aUm();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = aTZ.aUn();
                                } else {
                                    imageUrlData.urlType = ((com.baidu.tieba.pb.videopb.e) y.b(this.jaj.cnj()).l(com.baidu.tieba.pb.videopb.e.class)).isFromCDN() ? 17 : 18;
                                    str = aUm;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.jaj.clC().cnz(), -1L);
                                imageUrlData.mIsReserver = this.jaj.clC().cnQ();
                                imageUrlData.mIsSeeHost = this.jaj.clC().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b, imageUrlData);
                                }
                            }
                        }
                        if (!this.iIU) {
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
        if (tbRichTextData == null || tbRichTextData.aTZ() == null) {
            return null;
        }
        return tbRichTextData.aTZ().aUp();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTZ() == null) {
            return 0L;
        }
        return tbRichTextData.aTZ().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTZ() == null) {
            return false;
        }
        return tbRichTextData.aTZ().aUq();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTZ() == null) {
            return false;
        }
        return tbRichTextData.aTZ().aUr();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.dMK;
    }

    public com.baidu.tieba.pb.a.c cty() {
        return this.dqX;
    }
}
