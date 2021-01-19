package com.baidu.tieba.pb.videopb.b;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
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
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b {
    public BaseVideoPBReplyFragment mcP;
    public VideoPbFragment mcQ;
    private int lJO = 0;
    boolean lJP = false;
    private final TbRichTextView.i fSh = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r6v15, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0149 A[Catch: Exception -> 0x02e2, TryCatch #0 {Exception -> 0x02e2, blocks: (B:3:0x0003, B:5:0x0045, B:7:0x0072, B:9:0x0084, B:11:0x0090, B:13:0x009a, B:14:0x00a3, B:16:0x00a9, B:18:0x00af, B:21:0x00c0, B:24:0x00d1, B:25:0x0107, B:28:0x0110, B:30:0x0149, B:32:0x0175, B:33:0x0188, B:35:0x01c9, B:37:0x01d7, B:39:0x01f1, B:40:0x0201, B:42:0x0261, B:44:0x028d, B:45:0x02a0, B:49:0x02ec, B:51:0x02f4, B:53:0x02fc, B:55:0x030c, B:56:0x0326, B:58:0x032e, B:60:0x033c, B:61:0x0341, B:63:0x034b, B:65:0x0355, B:67:0x035f, B:68:0x0363, B:70:0x0369, B:72:0x0373, B:74:0x0389, B:75:0x03a3, B:77:0x03ae, B:78:0x03be, B:80:0x0412, B:82:0x043e, B:83:0x0451), top: B:86:0x0003 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, String str, int i, boolean z, boolean z2) {
            com.baidu.tieba.pb.videopb.fragment.a dsC;
            int i2;
            int i3 = 0;
            try {
                aq aqVar = new aq("c13398");
                aqVar.dW("tid", b.this.mcP.dkd().dme());
                aqVar.dW("fid", b.this.mcP.dkd().getForumId());
                aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.an("obj_locate", 3);
                aqVar.an("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(b.this.mcP.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.mcP.dkd().getPbData().djq()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bHg() != null) {
                            ArrayList<TbRichTextImageInfo> bHg = tbRichTextView.getRichText().bHg();
                            i2 = -1;
                            while (i3 < bHg.size()) {
                                if (bHg.get(i3) != null) {
                                    arrayList.add(bHg.get(i3).getSrc());
                                    if (i2 == -1 && str != null && str.equals(bHg.get(i3).getSrc())) {
                                        i2 = i3;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bHg.get(i3).getSrc();
                                    imageUrlData.originalUrl = bHg.get(i3).getSrc();
                                    imageUrlData.isLongPic = bHg.get(i3).bHD();
                                    concurrentHashMap.put(bHg.get(i3).getSrc(), imageUrlData);
                                }
                                i3++;
                                i2 = i2;
                            }
                            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                            aVar.s(arrayList).mN(i2).je(false).jf(b.this.mcP.dkd().dmx()).d(concurrentHashMap).jg(true).jh(false);
                            if (b.this.mcP.dkd() != null) {
                                aVar.ji(b.this.mcP.dkd().getHostMode());
                                aVar.zx(b.this.mcP.dkd().getFromForumId());
                                if (b.this.mcP.dkd().getPbData() != null) {
                                    aVar.s(b.this.mcP.dkd().getPbData().diN());
                                }
                            }
                            ImageViewerConfig eQ = aVar.eQ(b.this.mcP.getPageContext().getPageActivity());
                            eQ.getIntent().putExtra("from", "pb");
                            b.this.mcP.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eQ));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                    }
                    i2 = -1;
                    ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                    aVar2.s(arrayList).mN(i2).je(false).jf(b.this.mcP.dkd().dmx()).d(concurrentHashMap).jg(true).jh(false);
                    if (b.this.mcP.dkd() != null) {
                    }
                    ImageViewerConfig eQ2 = aVar2.eQ(b.this.mcP.getPageContext().getPageActivity());
                    eQ2.getIntent().putExtra("from", "pb");
                    b.this.mcP.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eQ2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar3 = new PbActivity.a();
                b.this.a(str, i, aVar3);
                if (aVar3.lEH) {
                    TbRichText bH = b.this.bH(str, i);
                    if (bH != null && b.this.lJO >= 0 && b.this.lJO < bH.bHf().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String c = g.c(bH.bHf().get(b.this.lJO));
                        int i4 = 0;
                        while (true) {
                            if (i4 >= aVar3.lEG.size()) {
                                break;
                            } else if (!aVar3.lEG.get(i4).equals(c)) {
                                i4++;
                            } else {
                                aVar3.index = i4;
                                arrayList2.add(c);
                                break;
                            }
                        }
                        if (bH.getPostId() != 0 && (dsC = b.this.mcP.dsC()) != null) {
                            ArrayList<n> dataList = dsC.getDataList();
                            if (x.getCount(dataList) > 0) {
                                Iterator<n> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    n next = it.next();
                                    if ((next instanceof PostData) && bH.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.mcP.dkd().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!x.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar3.eHG.get(str2));
                        }
                        ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                        aVar4.s(arrayList2).zs(aVar3.forumName).zt(aVar3.forumId).zu(aVar3.threadId).je(aVar3.eHE).jg(true).zv(aVar3.lastId).d(concurrentHashMap2).jh(false).jf(b.this.mcP.dkd().dmx()).zw(aVar3.postId);
                        if (b.this.mcP.dkd() != null) {
                            aVar4.ji(b.this.mcP.dkd().getHostMode());
                            aVar4.zx(b.this.mcP.dkd().getFromForumId());
                            if (b.this.mcP.dkd().getPbData() != null) {
                                aVar4.s(b.this.mcP.dkd().getPbData().diN());
                            }
                        }
                        ImageViewerConfig eQ3 = aVar4.eQ(b.this.mcP.getPageContext().getPageActivity());
                        eQ3.getIntent().putExtra("from", "pb");
                        b.this.mcP.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eQ3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(x.getItem(aVar3.lEG, 0));
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (!x.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar3.eHG.get(str3));
                }
                ImageViewerConfig.a aVar5 = new ImageViewerConfig.a();
                aVar5.s(arrayList3).zs(aVar3.forumName).zt(aVar3.forumId).zu(aVar3.threadId).je(aVar3.eHE).jg(true).zv(aVar3.lEG.get(0)).d(concurrentHashMap3).jf(b.this.mcP.dkd().dmx()).jh(false).zw(aVar3.postId).jj(false);
                if (b.this.mcP.dkd() != null) {
                    aVar5.ji(b.this.mcP.dkd().getHostMode());
                    aVar5.zx(b.this.mcP.dkd().getFromForumId());
                    if (b.this.mcP.dkd().getPbData() != null) {
                        aVar5.s(b.this.mcP.dkd().getPbData().diN());
                    }
                }
                ImageViewerConfig eQ4 = aVar5.eQ(b.this.mcP.getPageContext().getPageActivity());
                eQ4.getIntent().putExtra("from", "pb");
                b.this.mcP.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eQ4));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private c ftt = new c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.mcQ == null || !b.this.mcQ.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.mcQ != null && b.this.mcQ.dE(view)) {
                        return true;
                    }
                } else if (view.getId() == R.id.pb_floor_item_layout) {
                    if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                        b.this.g((SparseArray) view.getTag(R.id.tag_from));
                    }
                } else if ((view instanceof TbRichTextView) || view.getId() == R.id.pb_post_header_layout) {
                    SparseArray sparseArray = null;
                    if (view.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view.getTag();
                    }
                    if (sparseArray != null) {
                        b.this.g(sparseArray);
                    } else {
                        return false;
                    }
                }
            }
            if (b.this.mcQ != null) {
                b.this.mcQ.drR();
            }
            return true;
        }
    });

    public b(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        this.mcP = baseVideoPBReplyFragment;
        this.mcQ = baseVideoPBReplyFragment.dlK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.mcP.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.mcP.dkd() != null && this.mcP.dkd().getPbData() != null && postData.dLm() != 1) {
            String dme = this.mcP.dkd().dme();
            String id = postData.getId();
            int djc = this.mcP.dkd().getPbData() != null ? this.mcP.dkd().getPbData().djc() : 0;
            PbActivity.a OF = OF(id);
            if (OF != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.mcP.getPageContext().getPageActivity()).createSubPbActivityConfig(dme, id, "pb", true, null, false, null, djc, postData.dqX(), this.mcP.dkd().getPbData().getAnti(), false, postData.bnx() != null ? postData.bnx().getIconInfo() : null).addBigImageData(OF.lEG, OF.eHG, OF.eHE, OF.index);
                addBigImageData.setKeyPageStartFrom(this.mcP.dkd().dmP());
                addBigImageData.setFromFrsForumId(this.mcP.dkd().getFromForumId());
                addBigImageData.setKeyFromForumId(this.mcP.dkd().getForumId());
                addBigImageData.setBjhData(this.mcP.dkd().dmo());
                this.mcP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a OF(String str) {
        String str2;
        if (this.mcP.dkd() == null || this.mcP.dkd().getPbData() == null || this.mcP.dkd().getPbData().diP() == null || this.mcP.dkd().getPbData().diP().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.mcP.dkd().getPbData().diP().size()) {
                i = 0;
                break;
            } else if (str.equals(this.mcP.dkd().getPbData().diP().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.mcP.dkd().getPbData().diP().get(i);
        if (postData.dLo() == null || postData.dLo().bHf() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dLo().bHf().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bHl() != null) {
                    str2 = next.bHl().bHy();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        g.a(postData, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bH(String str, int i) {
        TbRichText tbRichText = null;
        if (this.mcP.dkd() == null || this.mcP.dkd().getPbData() == null || str == null || i < 0) {
            return null;
        }
        f pbData = this.mcP.dkd().getPbData();
        if (pbData.diW() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.diW());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> diP = pbData.diP();
            c(pbData, diP);
            return c(diP, str, i);
        }
        return tbRichText;
    }

    private void c(f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.djb() != null && fVar.djb().lCS != null && (list = fVar.djb().lCS) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bHf;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dLo = arrayList.get(i2).dLo();
            if (dLo != null && (bHf = dLo.bHf()) != null) {
                int size = bHf.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bHf.get(i4) != null && bHf.get(i4).getType() == 8) {
                        i3++;
                        if (bHf.get(i4).bHl().bHy().equals(str) || bHf.get(i4).bHl().bHz().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bHf.get(i4).bHl().getWidth() * equipmentDensity;
                            int height = bHf.get(i4).bHl().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lJO = i4;
                            return dLo;
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
            f pbData = this.mcP.dkd().getPbData();
            TbRichText bH = bH(str, i);
            if (bH != null && (tbRichTextData = bH.bHf().get(this.lJO)) != null) {
                aVar.postId = String.valueOf(bH.getPostId());
                aVar.lEG = new ArrayList<>();
                aVar.eHG = new ConcurrentHashMap<>();
                if (!tbRichTextData.bHl().bHw()) {
                    aVar.lEH = false;
                    String c = g.c(tbRichTextData);
                    aVar.lEG.add(c);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.mcP.dlL()).get(VideoPbViewModel.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = bH.getPostId();
                    imageUrlData.mIsReserver = this.mcP.dkd().dmx();
                    imageUrlData.mIsSeeHost = this.mcP.dkd().getHostMode();
                    aVar.eHG.put(c, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.diN() != null) {
                            aVar.threadId = pbData.diN().getId();
                        }
                        aVar.eHE = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lEH = true;
                int size = pbData.diP().size();
                this.lJP = false;
                aVar.index = -1;
                int a2 = pbData.diW() != null ? a(pbData.diW().dLo(), bH, i, i, aVar.lEG, aVar.eHG) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.diP().get(i2);
                    if (postData.getId() == null || pbData.diW() == null || pbData.diW().getId() == null || !postData.getId().equals(pbData.diW().getId())) {
                        a2 = a(postData.dLo(), bH, a2, i, aVar.lEG, aVar.eHG);
                    }
                }
                if (aVar.lEG.size() > 0) {
                    aVar.lastId = aVar.lEG.get(aVar.lEG.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.diN() != null) {
                        aVar.threadId = pbData.diN().getId();
                    }
                    aVar.eHE = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bHl;
        String str;
        if (tbRichText == tbRichText2) {
            this.lJP = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bHf().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bHf().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bHl().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bHl().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bHl().bHw()) {
                        if (tbRichText == tbRichText2 && i8 <= i2) {
                            i3 = i8;
                            i4 = i7 - 1;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else if (tbRichTextData.getType() == 20) {
                        i3 = i8;
                        i4 = i7;
                    } else {
                        String c = g.c(tbRichTextData);
                        if (!TextUtils.isEmpty(c)) {
                            arrayList.add(c);
                            if (tbRichTextData != null && (bHl = tbRichTextData.bHl()) != null) {
                                String bHy = bHl.bHy();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bHl.bHz();
                                } else {
                                    imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.mcP.dlL()).get(VideoPbViewModel.class)).isFromCDN() ? 17 : 18;
                                    str = bHy;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.mcP.dkd().dme(), -1L);
                                imageUrlData.mIsReserver = this.mcP.dkd().dmx();
                                imageUrlData.mIsSeeHost = this.mcP.dkd().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c, imageUrlData);
                                }
                            }
                        }
                        if (!this.lJP) {
                            i3 = i8;
                            i4 = i7 + 1;
                        }
                        i3 = i8;
                        i4 = i7;
                    }
                }
                i6++;
                i5 = i3;
                i7 = i4;
            }
            return i7;
        }
        return i;
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHl() == null) {
            return null;
        }
        return tbRichTextData.bHl().bHB();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHl() == null) {
            return 0L;
        }
        return tbRichTextData.bHl().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHl() == null) {
            return false;
        }
        return tbRichTextData.bHl().bHC();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHl() == null) {
            return false;
        }
        return tbRichTextData.bHl().bHD();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.fSh;
    }

    public c dsB() {
        return this.ftt;
    }
}
