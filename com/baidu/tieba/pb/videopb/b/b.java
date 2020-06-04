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
import com.baidu.adp.widget.ListView.o;
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
    public ReplyFragment keP;
    public VideoPbFragment keQ;
    private int jML = 0;
    boolean jMM = false;
    private final TbRichTextView.i eBN = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r2v57, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            c cLS;
            try {
                an anVar = new an("c13398");
                anVar.dh("tid", b.this.keP.cDO().cFJ());
                anVar.dh("fid", b.this.keP.cDO().getForumId());
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.ag("obj_locate", 3);
                anVar.ag("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(b.this.keP.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.keP.cDO().getPbData().cCZ()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    int i2 = -1;
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bit() != null) {
                            ArrayList<TbRichTextImageInfo> bit = tbRichTextView.getRichText().bit();
                            int i3 = 0;
                            while (i3 < bit.size()) {
                                if (bit.get(i3) != null) {
                                    arrayList.add(bit.get(i3).getSrc());
                                    if (i2 == -1 && str != null && str.equals(bit.get(i3).getSrc())) {
                                        i2 = i3;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bit.get(i3).getSrc();
                                    imageUrlData.originalUrl = bit.get(i3).getSrc();
                                    imageUrlData.isLongPic = bit.get(i3).biQ();
                                    concurrentHashMap.put(bit.get(i3).getSrc(), imageUrlData);
                                }
                                i3++;
                                i2 = i2;
                            }
                        }
                    }
                    ImageViewerConfig createConfig = new ImageViewerConfig(b.this.keP.getPageContext().getPageActivity()).createConfig(arrayList, i2, "", "", "", false, "", b.this.keP.cDO().cGb(), concurrentHashMap, true, false, z);
                    createConfig.getIntent().putExtra("from", "pb");
                    if (b.this.keP.cDO() != null && b.this.keP.cDO().getPbData() != null) {
                        createConfig.setThreadData(b.this.keP.cDO().getPbData().cCy());
                    }
                    b.this.keP.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar = new PbActivity.a();
                b.this.a(str, i, aVar);
                if (aVar.jIg) {
                    TbRichText bu = b.this.bu(str, i);
                    if (bu != null && b.this.jML >= 0 && b.this.jML < bu.bis().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String b = f.b(bu.bis().get(b.this.jML));
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= aVar.jId.size()) {
                                break;
                            } else if (!aVar.jId.get(i5).equals(b)) {
                                i4 = i5 + 1;
                            } else {
                                aVar.index = i5;
                                arrayList2.add(b);
                                break;
                            }
                        }
                        if (bu.getPostId() != 0 && (cLS = b.this.keP.cLS()) != null) {
                            ArrayList<o> dataList = cLS.getDataList();
                            if (v.getCount(dataList) > 0) {
                                Iterator<o> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    o next = it.next();
                                    if ((next instanceof PostData) && bu.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.keP.cDO().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!v.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar.jIe.get(str2));
                        }
                        ImageViewerConfig createConfig2 = new ImageViewerConfig(b.this.keP.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jIf, aVar.lastId, b.this.keP.cDO().cGb(), concurrentHashMap2, true, false, z);
                        createConfig2.getIntent().putExtra("from", "pb");
                        createConfig2.setPostId(aVar.postId);
                        if (b.this.keP.cDO() != null && b.this.keP.cDO().getPbData() != null) {
                            createConfig2.setThreadData(b.this.keP.cDO().getPbData().cCy());
                        }
                        b.this.keP.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(v.getItem(aVar.jId, 0));
                ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                if (!v.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar.jIe.get(str3));
                }
                ImageViewerConfig createConfig3 = new ImageViewerConfig(b.this.keP.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jIf, aVar.jId.get(0), b.this.keP.cDO().cGb(), concurrentHashMap3, true, false, z);
                createConfig3.getIntent().putExtra("from", "pb");
                createConfig3.setIsCanDrag(false);
                createConfig3.setPostId(aVar.postId);
                if (b.this.keP.cDO() != null && b.this.keP.cDO().getPbData() != null) {
                    createConfig3.setThreadData(b.this.keP.cDO().getPbData().cCy());
                }
                b.this.keP.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private com.baidu.tieba.pb.a.c efF = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.keQ == null || !b.this.keQ.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.keQ != null && b.this.keQ.cB(view)) {
                        return true;
                    }
                } else if (view.getId() == R.id.pb_floor_item_layout) {
                    if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                        b.this.d((SparseArray) view.getTag(R.id.tag_from));
                    }
                } else if ((view instanceof TbRichTextView) || view.getId() == R.id.pb_post_header_layout) {
                    SparseArray sparseArray = null;
                    if (view.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view.getTag();
                    }
                    if (sparseArray != null) {
                        b.this.d(sparseArray);
                    } else {
                        return false;
                    }
                }
            }
            if (b.this.keQ != null) {
                b.this.keQ.cLe();
            }
            return true;
        }
    });

    public b(ReplyFragment replyFragment) {
        this.keP = replyFragment;
        this.keQ = replyFragment.cFr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.keP.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.keP.cDO() != null && this.keP.cDO().getPbData() != null && postData.ddJ() != 1) {
            String cFJ = this.keP.cDO().cFJ();
            String id = postData.getId();
            int cCN = this.keP.cDO().getPbData() != null ? this.keP.cDO().getPbData().cCN() : 0;
            PbActivity.a Jp = Jp(id);
            if (Jp != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.keP.getPageContext().getPageActivity()).createSubPbActivityConfig(cFJ, id, "pb", true, null, false, null, cCN, postData.cKn(), this.keP.cDO().getPbData().getAnti(), false, postData.aQx() != null ? postData.aQx().getIconInfo() : null).addBigImageData(Jp.jId, Jp.jIe, Jp.jIf, Jp.index);
                addBigImageData.setKeyPageStartFrom(this.keP.cDO().cGt());
                addBigImageData.setFromFrsForumId(this.keP.cDO().getFromForumId());
                addBigImageData.setKeyFromForumId(this.keP.cDO().getForumId());
                addBigImageData.setBjhData(this.keP.cDO().cFS());
                this.keP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a Jp(String str) {
        String str2;
        if (this.keP.cDO() == null || this.keP.cDO().getPbData() == null || this.keP.cDO().getPbData().cCA() == null || this.keP.cDO().getPbData().cCA().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.keP.cDO().getPbData().cCA().size()) {
                i = 0;
                break;
            } else if (str.equals(this.keP.cDO().getPbData().cCA().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.keP.cDO().getPbData().cCA().get(i);
        if (postData.ddL() == null || postData.ddL().bis() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.ddL().bis().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.biy() != null) {
                    str2 = next.biy().biL();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        f.a(postData, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bu(String str, int i) {
        TbRichText tbRichText = null;
        if (this.keP.cDO() == null || this.keP.cDO().getPbData() == null || str == null || i < 0) {
            return null;
        }
        e pbData = this.keP.cDO().getPbData();
        if (pbData.cCH() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cCH());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cCA = pbData.cCA();
            c(pbData, cCA);
            return c(cCA, str, i);
        }
        return tbRichText;
    }

    private void c(e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.cCM() != null && eVar.cCM().jGE != null && (list = eVar.cCM().jGE) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bis;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText ddL = arrayList.get(i2).ddL();
            if (ddL != null && (bis = ddL.bis()) != null) {
                int size = bis.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bis.get(i4) != null && bis.get(i4).getType() == 8) {
                        i3++;
                        if (bis.get(i4).biy().biL().equals(str) || bis.get(i4).biy().biM().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bis.get(i4).biy().getWidth() * equipmentDensity;
                            int height = bis.get(i4).biy().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.jML = i4;
                            return ddL;
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
            e pbData = this.keP.cDO().getPbData();
            TbRichText bu = bu(str, i);
            if (bu != null && (tbRichTextData = bu.bis().get(this.jML)) != null) {
                aVar.postId = String.valueOf(bu.getPostId());
                aVar.jId = new ArrayList<>();
                aVar.jIe = new ConcurrentHashMap<>();
                if (!tbRichTextData.biy().biJ()) {
                    aVar.jIg = false;
                    String b = f.b(tbRichTextData);
                    aVar.jId.add(b);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((com.baidu.tieba.pb.videopb.e) y.b(this.keP.cFs()).l(com.baidu.tieba.pb.videopb.e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalSize = d(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                    imageUrlData.isLongPic = f(tbRichTextData);
                    imageUrlData.postId = bu.getPostId();
                    imageUrlData.mIsReserver = this.keP.cDO().cGb();
                    imageUrlData.mIsSeeHost = this.keP.cDO().getHostMode();
                    aVar.jIe.put(b, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cCy() != null) {
                            aVar.threadId = pbData.cCy().getId();
                        }
                        aVar.jIf = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.jIg = true;
                int size = pbData.cCA().size();
                this.jMM = false;
                aVar.index = -1;
                int a = pbData.cCH() != null ? a(pbData.cCH().ddL(), bu, i, i, aVar.jId, aVar.jIe) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cCA().get(i2);
                    if (postData.getId() == null || pbData.cCH() == null || pbData.cCH().getId() == null || !postData.getId().equals(pbData.cCH().getId())) {
                        a = a(postData.ddL(), bu, a, i, aVar.jId, aVar.jIe);
                    }
                }
                if (aVar.jId.size() > 0) {
                    aVar.lastId = aVar.jId.get(aVar.jId.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cCy() != null) {
                        aVar.threadId = pbData.cCy().getId();
                    }
                    aVar.jIf = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo biy;
        String str;
        if (tbRichText == tbRichText2) {
            this.jMM = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bis().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bis().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.biy().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.biy().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.biy().biJ()) {
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
                            if (tbRichTextData != null && (biy = tbRichTextData.biy()) != null) {
                                String biL = biy.biL();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = biy.biM();
                                } else {
                                    imageUrlData.urlType = ((com.baidu.tieba.pb.videopb.e) y.b(this.keP.cFs()).l(com.baidu.tieba.pb.videopb.e.class)).isFromCDN() ? 17 : 18;
                                    str = biL;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.keP.cDO().cFJ(), -1L);
                                imageUrlData.mIsReserver = this.keP.cDO().cGb();
                                imageUrlData.mIsSeeHost = this.keP.cDO().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b, imageUrlData);
                                }
                            }
                        }
                        if (!this.jMM) {
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
        if (tbRichTextData == null || tbRichTextData.biy() == null) {
            return null;
        }
        return tbRichTextData.biy().biO();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.biy() == null) {
            return 0L;
        }
        return tbRichTextData.biy().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.biy() == null) {
            return false;
        }
        return tbRichTextData.biy().biP();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.biy() == null) {
            return false;
        }
        return tbRichTextData.biy().biQ();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.eBN;
    }

    public com.baidu.tieba.pb.a.c cLK() {
        return this.efF;
    }
}
