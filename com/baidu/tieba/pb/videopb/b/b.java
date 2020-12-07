package com.baidu.tieba.pb.videopb.b;

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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
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
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes22.dex */
public class b {
    public BaseVideoPBReplyFragment mch;
    public VideoPbFragment mci;
    private int lJc = 0;
    boolean lJd = false;
    private final TbRichTextView.i fNk = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r6v16, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x014a A[Catch: Exception -> 0x02e3, TryCatch #0 {Exception -> 0x02e3, blocks: (B:3:0x0003, B:5:0x0045, B:7:0x0072, B:9:0x0084, B:11:0x0090, B:13:0x009a, B:14:0x00a4, B:16:0x00aa, B:18:0x00b0, B:21:0x00c1, B:24:0x00d2, B:25:0x0108, B:28:0x0111, B:30:0x014a, B:32:0x0176, B:33:0x0189, B:35:0x01ca, B:37:0x01d8, B:39:0x01f2, B:40:0x0202, B:42:0x0262, B:44:0x028e, B:45:0x02a1, B:49:0x02ed, B:51:0x02f5, B:53:0x02fd, B:55:0x030d, B:56:0x0326, B:58:0x032e, B:60:0x033c, B:61:0x0341, B:63:0x034b, B:65:0x0355, B:67:0x035f, B:68:0x0363, B:70:0x0369, B:72:0x0373, B:74:0x0389, B:75:0x03a3, B:77:0x03ae, B:78:0x03be, B:80:0x0412, B:82:0x043e, B:83:0x0451), top: B:86:0x0003 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, String str, int i, boolean z, boolean z2) {
            com.baidu.tieba.pb.videopb.fragment.a dwD;
            int i2;
            int i3 = 0;
            try {
                ar arVar = new ar("c13398");
                arVar.dY("tid", b.this.mch.dok().dqj());
                arVar.dY("fid", b.this.mch.dok().getForumId());
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.al("obj_locate", 3);
                arVar.al("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(arVar);
                TiebaStatic.eventStat(b.this.mch.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.mch.dok().getPbData().dnx()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bID() != null) {
                            ArrayList<TbRichTextImageInfo> bID = tbRichTextView.getRichText().bID();
                            int i4 = 0;
                            i2 = -1;
                            while (i4 < bID.size()) {
                                if (bID.get(i4) != null) {
                                    arrayList.add(bID.get(i4).getSrc());
                                    if (i2 == -1 && str != null && str.equals(bID.get(i4).getSrc())) {
                                        i2 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bID.get(i4).getSrc();
                                    imageUrlData.originalUrl = bID.get(i4).getSrc();
                                    imageUrlData.isLongPic = bID.get(i4).bJc();
                                    concurrentHashMap.put(bID.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i2 = i2;
                            }
                            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                            aVar.x(arrayList).oj(i2).iN(false).iO(b.this.mch.dok().dqC()).a(concurrentHashMap).iP(true).iQ(false);
                            if (b.this.mch.dok() != null) {
                                aVar.iR(b.this.mch.dok().getHostMode());
                                aVar.AL(b.this.mch.dok().getFromForumId());
                                if (b.this.mch.dok().getPbData() != null) {
                                    aVar.s(b.this.mch.dok().getPbData().dmT());
                                }
                            }
                            ImageViewerConfig ez = aVar.ez(b.this.mch.getPageContext().getPageActivity());
                            ez.getIntent().putExtra("from", "pb");
                            b.this.mch.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, ez));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                    }
                    i2 = -1;
                    ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                    aVar2.x(arrayList).oj(i2).iN(false).iO(b.this.mch.dok().dqC()).a(concurrentHashMap).iP(true).iQ(false);
                    if (b.this.mch.dok() != null) {
                    }
                    ImageViewerConfig ez2 = aVar2.ez(b.this.mch.getPageContext().getPageActivity());
                    ez2.getIntent().putExtra("from", "pb");
                    b.this.mch.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, ez2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar3 = new PbActivity.a();
                b.this.a(str, i, aVar3);
                if (aVar3.lDZ) {
                    TbRichText bz = b.this.bz(str, i);
                    if (bz != null && b.this.lJc >= 0 && b.this.lJc < bz.bIC().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String c = g.c(bz.bIC().get(b.this.lJc));
                        while (true) {
                            if (i3 >= aVar3.lDY.size()) {
                                break;
                            } else if (!aVar3.lDY.get(i3).equals(c)) {
                                i3++;
                            } else {
                                aVar3.index = i3;
                                arrayList2.add(c);
                                break;
                            }
                        }
                        if (bz.getPostId() != 0 && (dwD = b.this.mch.dwD()) != null) {
                            ArrayList<q> dataList = dwD.getDataList();
                            if (y.getCount(dataList) > 0) {
                                Iterator<q> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    q next = it.next();
                                    if ((next instanceof PostData) && bz.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.mch.dok().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!y.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar3.eCN.get(str2));
                        }
                        ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                        aVar4.x(arrayList2).AG(aVar3.forumName).AH(aVar3.forumId).AI(aVar3.threadId).iN(aVar3.eCL).iP(true).AJ(aVar3.lastId).a(concurrentHashMap2).iQ(false).iO(b.this.mch.dok().dqC()).AK(aVar3.postId);
                        if (b.this.mch.dok() != null) {
                            aVar4.iR(b.this.mch.dok().getHostMode());
                            aVar4.AL(b.this.mch.dok().getFromForumId());
                            if (b.this.mch.dok().getPbData() != null) {
                                aVar4.s(b.this.mch.dok().getPbData().dmT());
                            }
                        }
                        ImageViewerConfig ez3 = aVar4.ez(b.this.mch.getPageContext().getPageActivity());
                        ez3.getIntent().putExtra("from", "pb");
                        b.this.mch.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, ez3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(y.getItem(aVar3.lDY, 0));
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (!y.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar3.eCN.get(str3));
                }
                ImageViewerConfig.a aVar5 = new ImageViewerConfig.a();
                aVar5.x(arrayList3).AG(aVar3.forumName).AH(aVar3.forumId).AI(aVar3.threadId).iN(aVar3.eCL).iP(true).AJ(aVar3.lDY.get(0)).a(concurrentHashMap3).iO(b.this.mch.dok().dqC()).iQ(false).AK(aVar3.postId).iS(false);
                if (b.this.mch.dok() != null) {
                    aVar5.iR(b.this.mch.dok().getHostMode());
                    aVar5.AL(b.this.mch.dok().getFromForumId());
                    if (b.this.mch.dok().getPbData() != null) {
                        aVar5.s(b.this.mch.dok().getPbData().dmT());
                    }
                }
                ImageViewerConfig ez4 = aVar5.ez(b.this.mch.getPageContext().getPageActivity());
                ez4.getIntent().putExtra("from", "pb");
                b.this.mch.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, ez4));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    private c fos = new c(new c.a() { // from class: com.baidu.tieba.pb.videopb.b.b.2
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
            if (b.this.mci == null || !b.this.mci.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.mci != null && b.this.mci.du(view)) {
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
            if (b.this.mci != null) {
                b.this.mci.dvS();
            }
            return true;
        }
    });

    public b(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        this.mch = baseVideoPBReplyFragment;
        this.mci = baseVideoPBReplyFragment.dpP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.mch.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.mch.dok() != null && this.mch.dok().getPbData() != null && postData.dPg() != 1) {
            String dqj = this.mch.dok().dqj();
            String id = postData.getId();
            int dni = this.mch.dok().getPbData() != null ? this.mch.dok().getPbData().dni() : 0;
            PbActivity.a Qh = Qh(id);
            if (Qh != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.mch.getPageContext().getPageActivity()).createSubPbActivityConfig(dqj, id, "pb", true, null, false, null, dni, postData.duY(), this.mch.dok().getPbData().getAnti(), false, postData.boP() != null ? postData.boP().getIconInfo() : null).addBigImageData(Qh.lDY, Qh.eCN, Qh.eCL, Qh.index);
                addBigImageData.setKeyPageStartFrom(this.mch.dok().dqU());
                addBigImageData.setFromFrsForumId(this.mch.dok().getFromForumId());
                addBigImageData.setKeyFromForumId(this.mch.dok().getForumId());
                addBigImageData.setBjhData(this.mch.dok().dqt());
                this.mch.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a Qh(String str) {
        String str2;
        if (this.mch.dok() == null || this.mch.dok().getPbData() == null || this.mch.dok().getPbData().dmV() == null || this.mch.dok().getPbData().dmV().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.mch.dok().getPbData().dmV().size()) {
                i = 0;
                break;
            } else if (str.equals(this.mch.dok().getPbData().dmV().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.mch.dok().getPbData().dmV().get(i);
        if (postData.dPi() == null || postData.dPi().bIC() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dPi().bIC().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bII() != null) {
                    str2 = next.bII().bIX();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        g.a(postData, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bz(String str, int i) {
        TbRichText tbRichText = null;
        if (this.mch.dok() == null || this.mch.dok().getPbData() == null || str == null || i < 0) {
            return null;
        }
        f pbData = this.mch.dok().getPbData();
        if (pbData.dnc() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dnc());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dmV = pbData.dmV();
            c(pbData, dmV);
            return c(dmV, str, i);
        }
        return tbRichText;
    }

    private void c(f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dnh() != null && fVar.dnh().lCq != null && (list = fVar.dnh().lCq) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bIC;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dPi = arrayList.get(i2).dPi();
            if (dPi != null && (bIC = dPi.bIC()) != null) {
                int size = bIC.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bIC.get(i4) != null && bIC.get(i4).getType() == 8) {
                        i3++;
                        if (bIC.get(i4).bII().bIX().equals(str) || bIC.get(i4).bII().bIY().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bIC.get(i4).bII().getWidth() * equipmentDensity;
                            int height = bIC.get(i4).bII().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lJc = i4;
                            return dPi;
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
            f pbData = this.mch.dok().getPbData();
            TbRichText bz = bz(str, i);
            if (bz != null && (tbRichTextData = bz.bIC().get(this.lJc)) != null) {
                aVar.postId = String.valueOf(bz.getPostId());
                aVar.lDY = new ArrayList<>();
                aVar.eCN = new ConcurrentHashMap<>();
                if (!tbRichTextData.bII().bIV()) {
                    aVar.lDZ = false;
                    String c = g.c(tbRichTextData);
                    aVar.lDY.add(c);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((e) android.arch.lifecycle.y.b(this.mch.dpQ()).l(e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = bz.getPostId();
                    imageUrlData.mIsReserver = this.mch.dok().dqC();
                    imageUrlData.mIsSeeHost = this.mch.dok().getHostMode();
                    aVar.eCN.put(c, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dmT() != null) {
                            aVar.threadId = pbData.dmT().getId();
                        }
                        aVar.eCL = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lDZ = true;
                int size = pbData.dmV().size();
                this.lJd = false;
                aVar.index = -1;
                int a2 = pbData.dnc() != null ? a(pbData.dnc().dPi(), bz, i, i, aVar.lDY, aVar.eCN) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dmV().get(i2);
                    if (postData.getId() == null || pbData.dnc() == null || pbData.dnc().getId() == null || !postData.getId().equals(pbData.dnc().getId())) {
                        a2 = a(postData.dPi(), bz, a2, i, aVar.lDY, aVar.eCN);
                    }
                }
                if (aVar.lDY.size() > 0) {
                    aVar.lastId = aVar.lDY.get(aVar.lDY.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dmT() != null) {
                        aVar.threadId = pbData.dmT().getId();
                    }
                    aVar.eCL = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bII;
        String str;
        if (tbRichText == tbRichText2) {
            this.lJd = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bIC().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bIC().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bII().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bII().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bII().bIV()) {
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
                        String c = g.c(tbRichTextData);
                        if (!TextUtils.isEmpty(c)) {
                            arrayList.add(c);
                            if (tbRichTextData != null && (bII = tbRichTextData.bII()) != null) {
                                String bIX = bII.bIX();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bII.bIY();
                                } else {
                                    imageUrlData.urlType = ((e) android.arch.lifecycle.y.b(this.mch.dpQ()).l(e.class)).isFromCDN() ? 17 : 18;
                                    str = bIX;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.mch.dok().dqj(), -1L);
                                imageUrlData.mIsReserver = this.mch.dok().dqC();
                                imageUrlData.mIsSeeHost = this.mch.dok().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c, imageUrlData);
                                }
                            }
                        }
                        if (!this.lJd) {
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
        if (tbRichTextData == null || tbRichTextData.bII() == null) {
            return null;
        }
        return tbRichTextData.bII().bJa();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bII() == null) {
            return 0L;
        }
        return tbRichTextData.bII().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bII() == null) {
            return false;
        }
        return tbRichTextData.bII().bJb();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bII() == null) {
            return false;
        }
        return tbRichTextData.bII().bJc();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.fNk;
    }

    public c dwC() {
        return this.fos;
    }
}
