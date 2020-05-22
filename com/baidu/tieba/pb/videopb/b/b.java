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
    public ReplyFragment kdI;
    public VideoPbFragment kdJ;
    private int jLF = 0;
    boolean jLG = false;
    private final TbRichTextView.i eBC = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.videopb.b.b.1
        /* JADX DEBUG: Multi-variable search result rejected for r2v57, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            c cLC;
            try {
                an anVar = new an("c13398");
                anVar.dh("tid", b.this.kdI.cDy().cFt());
                anVar.dh("fid", b.this.kdI.cDy().getForumId());
                anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.ag("obj_locate", 3);
                anVar.ag("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(b.this.kdI.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.kdI.cDy().getPbData().cCJ()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    int i2 = -1;
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bir() != null) {
                            ArrayList<TbRichTextImageInfo> bir = tbRichTextView.getRichText().bir();
                            int i3 = 0;
                            while (i3 < bir.size()) {
                                if (bir.get(i3) != null) {
                                    arrayList.add(bir.get(i3).getSrc());
                                    if (i2 == -1 && str != null && str.equals(bir.get(i3).getSrc())) {
                                        i2 = i3;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bir.get(i3).getSrc();
                                    imageUrlData.originalUrl = bir.get(i3).getSrc();
                                    imageUrlData.isLongPic = bir.get(i3).biO();
                                    concurrentHashMap.put(bir.get(i3).getSrc(), imageUrlData);
                                }
                                i3++;
                                i2 = i2;
                            }
                        }
                    }
                    ImageViewerConfig createConfig = new ImageViewerConfig(b.this.kdI.getPageContext().getPageActivity()).createConfig(arrayList, i2, "", "", "", false, "", b.this.kdI.cDy().cFL(), concurrentHashMap, true, false, z);
                    createConfig.getIntent().putExtra("from", "pb");
                    if (b.this.kdI.cDy() != null && b.this.kdI.cDy().getPbData() != null) {
                        createConfig.setThreadData(b.this.kdI.cDy().getPbData().cCi());
                    }
                    b.this.kdI.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                PbActivity.a aVar = new PbActivity.a();
                b.this.a(str, i, aVar);
                if (aVar.jHa) {
                    TbRichText bu = b.this.bu(str, i);
                    if (bu != null && b.this.jLF >= 0 && b.this.jLF < bu.biq().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String b = f.b(bu.biq().get(b.this.jLF));
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= aVar.jGX.size()) {
                                break;
                            } else if (!aVar.jGX.get(i5).equals(b)) {
                                i4 = i5 + 1;
                            } else {
                                aVar.index = i5;
                                arrayList2.add(b);
                                break;
                            }
                        }
                        if (bu.getPostId() != 0 && (cLC = b.this.kdI.cLC()) != null) {
                            ArrayList<o> dataList = cLC.getDataList();
                            if (v.getCount(dataList) > 0) {
                                Iterator<o> it = dataList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    o next = it.next();
                                    if ((next instanceof PostData) && bu.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                        com.baidu.tieba.pb.c.a.a(b.this.kdI.cDy().getPbData(), (PostData) next, ((PostData) next).locate, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!v.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, aVar.jGY.get(str2));
                        }
                        ImageViewerConfig createConfig2 = new ImageViewerConfig(b.this.kdI.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jGZ, aVar.lastId, b.this.kdI.cDy().cFL(), concurrentHashMap2, true, false, z);
                        createConfig2.getIntent().putExtra("from", "pb");
                        createConfig2.setPostId(aVar.postId);
                        if (b.this.kdI.cDy() != null && b.this.kdI.cDy().getPbData() != null) {
                            createConfig2.setThreadData(b.this.kdI.cDy().getPbData().cCi());
                        }
                        b.this.kdI.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(v.getItem(aVar.jGX, 0));
                ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                if (!v.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, aVar.jGY.get(str3));
                }
                ImageViewerConfig createConfig3 = new ImageViewerConfig(b.this.kdI.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.jGZ, aVar.jGX.get(0), b.this.kdI.cDy().cFL(), concurrentHashMap3, true, false, z);
                createConfig3.getIntent().putExtra("from", "pb");
                createConfig3.setIsCanDrag(false);
                createConfig3.setPostId(aVar.postId);
                if (b.this.kdI.cDy() != null && b.this.kdI.cDy().getPbData() != null) {
                    createConfig3.setThreadData(b.this.kdI.cDy().getPbData().cCi());
                }
                b.this.kdI.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig3));
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
            if (b.this.kdJ == null || !b.this.kdJ.isAdded()) {
                return true;
            }
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (b.this.kdJ != null && b.this.kdJ.cB(view)) {
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
            if (b.this.kdJ != null) {
                b.this.kdJ.cKO();
            }
            return true;
        }
    });

    public b(ReplyFragment replyFragment) {
        this.kdI = replyFragment;
        this.kdJ = replyFragment.cFb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (this.kdI.checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.kdI.cDy() != null && this.kdI.cDy().getPbData() != null && postData.ddu() != 1) {
            String cFt = this.kdI.cDy().cFt();
            String id = postData.getId();
            int cCx = this.kdI.cDy().getPbData() != null ? this.kdI.cDy().getPbData().cCx() : 0;
            PbActivity.a Jo = Jo(id);
            if (Jo != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.kdI.getPageContext().getPageActivity()).createSubPbActivityConfig(cFt, id, "pb", true, null, false, null, cCx, postData.cJX(), this.kdI.cDy().getPbData().getAnti(), false, postData.aQx() != null ? postData.aQx().getIconInfo() : null).addBigImageData(Jo.jGX, Jo.jGY, Jo.jGZ, Jo.index);
                addBigImageData.setKeyPageStartFrom(this.kdI.cDy().cGd());
                addBigImageData.setFromFrsForumId(this.kdI.cDy().getFromForumId());
                addBigImageData.setKeyFromForumId(this.kdI.cDy().getForumId());
                addBigImageData.setBjhData(this.kdI.cDy().cFC());
                this.kdI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    public PbActivity.a Jo(String str) {
        String str2;
        if (this.kdI.cDy() == null || this.kdI.cDy().getPbData() == null || this.kdI.cDy().getPbData().cCk() == null || this.kdI.cDy().getPbData().cCk().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.kdI.cDy().getPbData().cCk().size()) {
                i = 0;
                break;
            } else if (str.equals(this.kdI.cDy().getPbData().cCk().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.kdI.cDy().getPbData().cCk().get(i);
        if (postData.ddw() == null || postData.ddw().biq() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.ddw().biq().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.biw() != null) {
                    str2 = next.biw().biJ();
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
        if (this.kdI.cDy() == null || this.kdI.cDy().getPbData() == null || str == null || i < 0) {
            return null;
        }
        e pbData = this.kdI.cDy().getPbData();
        if (pbData.cCr() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cCr());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cCk = pbData.cCk();
            c(pbData, cCk);
            return c(cCk, str, i);
        }
        return tbRichText;
    }

    private void c(e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.cCw() != null && eVar.cCw().jFy != null && (list = eVar.cCw().jFy) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> biq;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText ddw = arrayList.get(i2).ddw();
            if (ddw != null && (biq = ddw.biq()) != null) {
                int size = biq.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (biq.get(i4) != null && biq.get(i4).getType() == 8) {
                        i3++;
                        if (biq.get(i4).biw().biJ().equals(str) || biq.get(i4).biw().biK().equals(str)) {
                            int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = biq.get(i4).biw().getWidth() * equipmentDensity;
                            int height = biq.get(i4).biw().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.jLF = i4;
                            return ddw;
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
            e pbData = this.kdI.cDy().getPbData();
            TbRichText bu = bu(str, i);
            if (bu != null && (tbRichTextData = bu.biq().get(this.jLF)) != null) {
                aVar.postId = String.valueOf(bu.getPostId());
                aVar.jGX = new ArrayList<>();
                aVar.jGY = new ConcurrentHashMap<>();
                if (!tbRichTextData.biw().biH()) {
                    aVar.jHa = false;
                    String b = f.b(tbRichTextData);
                    aVar.jGX.add(b);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = ((com.baidu.tieba.pb.videopb.e) y.b(this.kdI.cFc()).l(com.baidu.tieba.pb.videopb.e.class)).isFromCDN() ? 17 : 18;
                    }
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalUrl = c(tbRichTextData);
                    imageUrlData.originalSize = d(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                    imageUrlData.isLongPic = f(tbRichTextData);
                    imageUrlData.postId = bu.getPostId();
                    imageUrlData.mIsReserver = this.kdI.cDy().cFL();
                    imageUrlData.mIsSeeHost = this.kdI.cDy().getHostMode();
                    aVar.jGY.put(b, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cCi() != null) {
                            aVar.threadId = pbData.cCi().getId();
                        }
                        aVar.jGZ = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.jHa = true;
                int size = pbData.cCk().size();
                this.jLG = false;
                aVar.index = -1;
                int a = pbData.cCr() != null ? a(pbData.cCr().ddw(), bu, i, i, aVar.jGX, aVar.jGY) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cCk().get(i2);
                    if (postData.getId() == null || pbData.cCr() == null || pbData.cCr().getId() == null || !postData.getId().equals(pbData.cCr().getId())) {
                        a = a(postData.ddw(), bu, a, i, aVar.jGX, aVar.jGY);
                    }
                }
                if (aVar.jGX.size() > 0) {
                    aVar.lastId = aVar.jGX.get(aVar.jGX.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cCi() != null) {
                        aVar.threadId = pbData.cCi().getId();
                    }
                    aVar.jGZ = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a;
            }
        }
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo biw;
        String str;
        if (tbRichText == tbRichText2) {
            this.jLG = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.biq().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.biq().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.biw().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.biw().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.biw().biH()) {
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
                            if (tbRichTextData != null && (biw = tbRichTextData.biw()) != null) {
                                String biJ = biw.biJ();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = biw.biK();
                                } else {
                                    imageUrlData.urlType = ((com.baidu.tieba.pb.videopb.e) y.b(this.kdI.cFc()).l(com.baidu.tieba.pb.videopb.e.class)).isFromCDN() ? 17 : 18;
                                    str = biJ;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.kdI.cDy().cFt(), -1L);
                                imageUrlData.mIsReserver = this.kdI.cDy().cFL();
                                imageUrlData.mIsSeeHost = this.kdI.cDy().getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b, imageUrlData);
                                }
                            }
                        }
                        if (!this.jLG) {
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
        if (tbRichTextData == null || tbRichTextData.biw() == null) {
            return null;
        }
        return tbRichTextData.biw().biM();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.biw() == null) {
            return 0L;
        }
        return tbRichTextData.biw().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.biw() == null) {
            return false;
        }
        return tbRichTextData.biw().biN();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.biw() == null) {
            return false;
        }
        return tbRichTextData.biw().biO();
    }

    public TbRichTextView.i getOnImageClickListener() {
        return this.eBC;
    }

    public com.baidu.tieba.pb.a.c cLu() {
        return this.efF;
    }
}
