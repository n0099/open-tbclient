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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
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
    public ReplyFragment kyD;
    public VideoPbFragment kyE;
    private int kgw = 0;
    boolean kgx = false;
    private final TbRichTextView.i eLw = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r2v57, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            c cQj;
            try {
                ao aoVar = new ao("c13398");
                aoVar.dk("tid", b.this.kyD.cIe().cJZ());
                aoVar.dk("fid", b.this.kyD.cIe().getForumId());
                aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                aoVar.ag("obj_locate", 3);
                aoVar.ag("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aoVar);
                TiebaStatic.eventStat(b.this.kyD.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.kyD.cIe().getPbData().cHp()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    int i2 = -1;
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bkP() != null) {
                            ArrayList<TbRichTextImageInfo> bkP = tbRichTextView.getRichText().bkP();
                            int i3 = 0;
                            while (i3 < bkP.size()) {
                                if (bkP.get(i3) != null) {
                                    arrayList.add(bkP.get(i3).getSrc());
                                    if (i2 == -1 && str != null && str.equals(bkP.get(i3).getSrc())) {
                                        i2 = i3;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bkP.get(i3).getSrc();
                                    imageUrlData.originalUrl = bkP.get(i3).getSrc();
                                    imageUrlData.isLongPic = bkP.get(i3).blo();
                                    concurrentHashMap.put(bkP.get(i3).getSrc(), imageUrlData);
                                }
                                i3++;
                                i2 = i2;
                            }
                        }
                    }
                    ImageViewerConfig createConfig = new ImageViewerConfig(b.this.kyD.getPageContext().getPageActivity()).createConfig(arrayList, i2, "", "", "", false, "", b.this.kyD.cIe().cKr(), concurrentHashMap, true, false, z);
                    createConfig.getIntent().putExtra("from", "pb");
                    if (b.this.kyD.cIe() != null && b.this.kyD.cIe().getPbData() != null) {
                        createConfig.setThreadData(b.this.kyD.cIe().getPbData().cGN());
                    }
                    b.this.kyD.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar = new PbActivity.a();
                b.this.a(str, i, aVar);
                if (aVar.kbQ) {
                    TbRichText bt = b.this.bt(str, i);
                    if (bt != null && b.this.kgw >= 0 && b.this.kgw < bt.bkO().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String c = f.c(bt.bkO().get(b.this.kgw));
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= aVar.kbN.size()) {
                                break;
                            } else if (!aVar.kbN.get(i5).equals(c)) {
                                i4 = i5 + 1;
                            } else {
                                aVar.index = i5;
                                arrayList2.add(c);
                                break;
                            }
                        }
                        if (bt.getPostId() != 0 && (cQj = b.this.kyD.cQj()) != null) {
                            ArrayList<q> dataList = cQj.getDataList();
                            if (w.getCount(dataList) > 0) {
                                Iterator<q> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    q next = it.next();
                                    if ((next instanceof PostData) && bt.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.kyD.cIe().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!w.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar.kbO.get(str2));
                        }
                        ImageViewerConfig createConfig2 = new ImageViewerConfig(b.this.kyD.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.kbP, aVar.lastId, b.this.kyD.cIe().cKr(), concurrentHashMap2, true, false, z);
                        createConfig2.getIntent().putExtra("from", "pb");
                        createConfig2.setPostId(aVar.postId);
                        if (b.this.kyD.cIe() != null && b.this.kyD.cIe().getPbData() != null) {
                            createConfig2.setThreadData(b.this.kyD.cIe().getPbData().cGN());
                        }
                        b.this.kyD.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(w.getItem(aVar.kbN, 0));
                ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                if (!w.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar.kbO.get(str3));
                }
                ImageViewerConfig createConfig3 = new ImageViewerConfig(b.this.kyD.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.kbP, aVar.kbN.get(0), b.this.kyD.cIe().cKr(), concurrentHashMap3, true, false, z);
                createConfig3.getIntent().putExtra("from", "pb");
                createConfig3.setIsCanDrag(false);
                createConfig3.setPostId(aVar.postId);
                if (b.this.kyD.cIe() != null && b.this.kyD.cIe().getPbData() != null) {
                    createConfig3.setThreadData(b.this.kyD.cIe().getPbData().cGN());
                }
                b.this.kyD.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private com.baidu.tieba.pb.a.c eor = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.kyE == null || !b.this.kyE.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.kyE != null && b.this.kyE.cC(view)) {
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
            if (b.this.kyE != null) {
                b.this.kyE.cPv();
            }
            return true;
        }
    });

    public b(ReplyFragment replyFragment) {
        this.kyD = replyFragment;
        this.kyE = replyFragment.cJH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.kyD.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.kyD.cIe() != null && this.kyD.cIe().getPbData() != null && postData.dhY() != 1) {
            String cJZ = this.kyD.cIe().cJZ();
            String id = postData.getId();
            int cHc = this.kyD.cIe().getPbData() != null ? this.kyD.cIe().getPbData().cHc() : 0;
            PbActivity.a JR = JR(id);
            if (JR != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.kyD.getPageContext().getPageActivity()).createSubPbActivityConfig(cJZ, id, "pb", true, null, false, null, cHc, postData.cOE(), this.kyD.cIe().getPbData().getAnti(), false, postData.aSp() != null ? postData.aSp().getIconInfo() : null).addBigImageData(JR.kbN, JR.kbO, JR.kbP, JR.index);
                addBigImageData.setKeyPageStartFrom(this.kyD.cIe().cKJ());
                addBigImageData.setFromFrsForumId(this.kyD.cIe().getFromForumId());
                addBigImageData.setKeyFromForumId(this.kyD.cIe().getForumId());
                addBigImageData.setBjhData(this.kyD.cIe().cKi());
                this.kyD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a JR(String str) {
        String str2;
        if (this.kyD.cIe() == null || this.kyD.cIe().getPbData() == null || this.kyD.cIe().getPbData().cGP() == null || this.kyD.cIe().getPbData().cGP().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.kyD.cIe().getPbData().cGP().size()) {
                i = 0;
                break;
            } else if (str.equals(this.kyD.cIe().getPbData().cGP().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.kyD.cIe().getPbData().cGP().get(i);
        if (postData.dia() == null || postData.dia().bkO() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dia().bkO().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bkU() != null) {
                    str2 = next.bkU().blj();
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
        if (this.kyD.cIe() == null || this.kyD.cIe().getPbData() == null || str == null || i < 0) {
            return null;
        }
        e pbData = this.kyD.cIe().getPbData();
        if (pbData.cGW() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cGW());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cGP = pbData.cGP();
            c(pbData, cGP);
            return c(cGP, str, i);
        }
        return tbRichText;
    }

    private void c(e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.cHb() != null && eVar.cHb().kao != null && (list = eVar.cHb().kao) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bkO;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dia = arrayList.get(i2).dia();
            if (dia != null && (bkO = dia.bkO()) != null) {
                int size = bkO.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bkO.get(i4) != null && bkO.get(i4).getType() == 8) {
                        i3++;
                        if (bkO.get(i4).bkU().blj().equals(str) || bkO.get(i4).bkU().blk().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bkO.get(i4).bkU().getWidth() * equipmentDensity;
                            int height = bkO.get(i4).bkU().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.kgw = i4;
                            return dia;
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
            e pbData = this.kyD.cIe().getPbData();
            TbRichText bt = bt(str, i);
            if (bt != null && (tbRichTextData = bt.bkO().get(this.kgw)) != null) {
                aVar.postId = String.valueOf(bt.getPostId());
                aVar.kbN = new ArrayList<>();
                aVar.kbO = new ConcurrentHashMap<>();
                if (!tbRichTextData.bkU().blh()) {
                    aVar.kbQ = false;
                    String c = f.c(tbRichTextData);
                    aVar.kbN.add(c);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((com.baidu.tieba.pb.videopb.e) y.b(this.kyD.cJI()).l(com.baidu.tieba.pb.videopb.e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = bt.getPostId();
                    imageUrlData.mIsReserver = this.kyD.cIe().cKr();
                    imageUrlData.mIsSeeHost = this.kyD.cIe().getHostMode();
                    aVar.kbO.put(c, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cGN() != null) {
                            aVar.threadId = pbData.cGN().getId();
                        }
                        aVar.kbP = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.kbQ = true;
                int size = pbData.cGP().size();
                this.kgx = false;
                aVar.index = -1;
                int a = pbData.cGW() != null ? a(pbData.cGW().dia(), bt, i, i, aVar.kbN, aVar.kbO) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cGP().get(i2);
                    if (postData.getId() == null || pbData.cGW() == null || pbData.cGW().getId() == null || !postData.getId().equals(pbData.cGW().getId())) {
                        a = a(postData.dia(), bt, a, i, aVar.kbN, aVar.kbO);
                    }
                }
                if (aVar.kbN.size() > 0) {
                    aVar.lastId = aVar.kbN.get(aVar.kbN.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cGN() != null) {
                        aVar.threadId = pbData.cGN().getId();
                    }
                    aVar.kbP = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bkU;
        String str;
        if (tbRichText == tbRichText2) {
            this.kgx = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bkO().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bkO().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bkU().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bkU().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bkU().blh()) {
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
                        String c = f.c(tbRichTextData);
                        if (!TextUtils.isEmpty(c)) {
                            arrayList.add(c);
                            if (tbRichTextData != null && (bkU = tbRichTextData.bkU()) != null) {
                                String blj = bkU.blj();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bkU.blk();
                                } else {
                                    imageUrlData.urlType = ((com.baidu.tieba.pb.videopb.e) y.b(this.kyD.cJI()).l(com.baidu.tieba.pb.videopb.e.class)).isFromCDN() ? 17 : 18;
                                    str = blj;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.kyD.cIe().cJZ(), -1L);
                                imageUrlData.mIsReserver = this.kyD.cIe().cKr();
                                imageUrlData.mIsSeeHost = this.kyD.cIe().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c, imageUrlData);
                                }
                            }
                        }
                        if (!this.kgx) {
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

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bkU() == null) {
            return null;
        }
        return tbRichTextData.bkU().blm();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bkU() == null) {
            return 0L;
        }
        return tbRichTextData.bkU().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bkU() == null) {
            return false;
        }
        return tbRichTextData.bkU().bln();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bkU() == null) {
            return false;
        }
        return tbRichTextData.bkU().blo();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.eLw;
    }

    public com.baidu.tieba.pb.a.c cQb() {
        return this.eor;
    }
}
