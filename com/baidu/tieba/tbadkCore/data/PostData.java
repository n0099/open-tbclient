package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements com.baidu.adp.widget.ListView.n, ah {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private List<HeadItem> eOA;
    private SkinInfo eSw;
    private String eSz;
    private Item eTW;
    private OriginalThreadInfo eTc;
    private TbRichTextVoiceInfo fld;
    public int isAuthorView;
    private String lKQ;
    public int locate;
    private SmallTailInfo mih;
    private String nxA;
    private String nxB;
    private TPointPost nxC;
    public int nxF;
    public boolean nxI;
    public AlaLiveInfoCoreData nxL;
    private boolean nxP;
    public ar nxT;
    public List<PbContent> nxW;
    public Item nxY;
    private String nxg;
    private ArrayList<PostData> nxk;
    private com.baidu.tbadk.data.c nxr;
    private com.baidu.tbadk.data.g nxs;
    private i nxv;
    private bx nxw;
    public boolean nxy;
    private com.baidu.tbadk.widget.richText.i nxz;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId nwX = BdUniqueId.gen();
    public static final BdUniqueId nwY = BdUniqueId.gen();
    public static final BdUniqueId eSx = BdUniqueId.gen();
    public static final BdUniqueId eQE = BdUniqueId.gen();
    public static final BdUniqueId eQK = BdUniqueId.gen();
    public static final BdUniqueId nwZ = BdUniqueId.gen();
    public static final BdUniqueId nxa = BdUniqueId.gen();
    public static final BdUniqueId nxb = BdUniqueId.gen();
    public static final BdUniqueId nxc = BdUniqueId.gen();
    public static final BdUniqueId nxd = BdUniqueId.gen();
    public static boolean nxe = false;
    private int nxf = 0;
    private boolean nxl = false;
    private ArrayList<PostData> nxm = null;
    private TbRichText nxn = null;
    private boolean nxq = false;
    private boolean nxt = false;
    private boolean nxu = false;
    public boolean nxx = false;
    public int eRW = 0;
    private boolean nxD = false;
    public boolean jpu = false;
    public boolean nxE = false;
    public boolean nxG = false;
    public boolean nxH = true;
    public boolean nxJ = false;
    public boolean nxK = false;
    private boolean nxM = false;
    private int nxN = 0;
    private boolean nxO = true;
    public boolean nxQ = false;
    public boolean nxR = false;
    public boolean nxS = false;
    public boolean nxU = false;
    public boolean nxV = false;
    int nxX = com.baidu.tbadk.a.d.bji();
    private b nxZ = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.nxT != null) {
                ar bsN = PostData.this.nxT.bsN();
                bsN.delete("obj_locate");
                bsN.ap("obj_locate", 7);
                TiebaStatic.log(bsN);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData eRz = new MetaData();
    private ArrayList<l> nxh = new ArrayList<>();
    private ArrayList<l> nxi = new ArrayList<>();
    private int nxj = 0;
    private int eSh = 0;
    private PraiseData eRK = new PraiseData();
    private bb nxo = new bb();
    private c nxp = new c();
    private ArrayList<com.baidu.tbadk.data.c> eSt = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.nxk = null;
        this.nxF = 0;
        this.nxk = new ArrayList<>();
        this.nxF = 0;
    }

    public void ys(boolean z) {
        this.nxP = z;
    }

    public boolean dNx() {
        return this.nxP;
    }

    public ArrayList<PostData> dNy() {
        return this.nxm;
    }

    public void dNz() {
        this.nxm.clear();
        this.nxm = null;
        this.nxl = false;
    }

    public void y(PostData postData) {
        if (postData != null) {
            if (this.nxm == null) {
                this.nxm = new ArrayList<>();
                if (y.getCount(this.nxk) > this.nxX) {
                    this.nxm.addAll(y.subList(this.nxk, 0, this.nxX));
                } else {
                    this.nxm.addAll(this.nxk);
                }
            }
            this.nxm.add(postData);
        }
    }

    public void z(PostData postData) {
        if (postData != null && this.nxk != null) {
            this.nxk.add(postData);
            dND();
        }
    }

    public void Tq(String str) {
        if (this.nxm != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.nxm.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.nxm.remove(next);
                    return;
                }
            }
        }
    }

    public void yt(boolean z) {
        this.nxO = z;
    }

    public boolean dNA() {
        return this.nxO;
    }

    public void yu(boolean z) {
        this.nxl = z;
    }

    public boolean dNB() {
        return this.nxl;
    }

    public ArrayList<PostData> dNC() {
        return this.nxk;
    }

    public void dND() {
        this.nxj++;
    }

    public void dNE() {
        this.nxj--;
    }

    public void JD(int i) {
        this.nxj = i;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public long getTid() {
        return this.tid;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int dNF() {
        return this.floor_num;
    }

    public void JE(int i) {
        this.floor_num = i;
    }

    public boolean dNG() {
        return this.nxu;
    }

    public void yv(boolean z) {
        this.nxu = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = au.getFormatTime(j);
    }

    public MetaData bnQ() {
        return this.eRz;
    }

    public void a(MetaData metaData) {
        this.eRz = metaData;
    }

    public void a(PraiseData praiseData) {
        this.eRK = praiseData;
    }

    public TbRichText dNH() {
        return this.nxn;
    }

    public void c(TbRichText tbRichText) {
        this.nxn = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo dts() {
        return this.mih;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.mih = smallTailInfo;
    }

    public com.baidu.tbadk.data.g dNI() {
        return this.nxs;
    }

    public SkinInfo bol() {
        return this.eSw;
    }

    public void yw(boolean z) {
        this.nxM = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.nxn != null && this.nxn.bHz() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            String str3 = null;
            if (z) {
                str = " 楼主";
            } else {
                if (this.eRz != null && this.eRz.getIs_bawu() == 1) {
                    if (this.nxP) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.eRz.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.eRz.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.eRz.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.eRz.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = bnQ().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.d.mw().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.d.mw().a(next.getIcon(), 21, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.c
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.nxn.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.eRz.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.eRz.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.eRz != null) {
                spannableString = new SpannableString(sb2 + this.eRz.getName_show() + str + "：");
                String userName = this.eRz.getUserName();
                str2 = this.eRz.getUserId();
                str3 = userName;
            } else {
                spannableString = new SpannableString(sb2 + str + "：");
                str2 = null;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.eRz.getSealPrefix())) {
                Bitmap bitmap = ap.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.eRz.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str3, str2, this.nxZ), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.eRz != null && this.eRz.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b i3 = i(z, this.eRz != null && this.eRz.getIs_bawu() == 1, str);
                if (i3 != null) {
                    if (this.eRz != null) {
                        int i4 = 0;
                        if (this.eRz.getName_show() != null) {
                            i4 = this.eRz.getName_show().length();
                        }
                        spannableString.setSpan(i3, sb2.length() + i4 + 1, i4 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(i3, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bHz = this.nxn.bHz();
            if (bHz != null && bHz.size() > 0) {
                TbRichTextData tbRichTextData2 = bHz.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bHG() != null) {
                    if (this.nxM) {
                        int indexOf = tbRichTextData2.bHG().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bHG().delete(0, indexOf + 1);
                        }
                        this.nxM = false;
                    }
                    tbRichTextData2.sk(sb.length());
                    tbRichTextData2.bHG().insert(0, (CharSequence) spannableString);
                } else {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= bHz.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bHz.get(i6) == null || bHz.get(i6).getType() != 512) {
                            i5 = i6 + 1;
                        } else {
                            TbRichTextVoiceInfo bHH = bHz.get(i6).bHH();
                            bHz.remove(i6);
                            tbRichTextVoiceInfo = bHH;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.sk(sb.length());
                    tbRichTextData.p(spannableString);
                    bHz.add(0, tbRichTextData);
                }
            }
            this.nxQ = true;
        }
    }

    private com.baidu.tbadk.core.view.b i(boolean z, boolean z2, String str) {
        if (z || z2) {
            Context context = TbadkCoreApplication.getInst().getContext();
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.L_X01);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12);
            int dimens5 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40);
            if (" 楼主".equals(str)) {
                com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0302, dimens4, dimens5);
                bVar.pl(dimens2);
                bVar.jW(false);
                bVar.By(str);
                return bVar;
            } else if (" 吧主".equals(str) || " 小吧主".equals(str) || " 品牌官".equals(str)) {
                com.baidu.tbadk.core.view.b bVar2 = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0101, dimens4, dimens5);
                bVar2.pl(dimens2);
                bVar2.jW(true);
                bVar2.By(str);
                return bVar2;
            } else {
                return null;
            }
        }
        return null;
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
        return bitmapDrawable;
    }

    public int dNJ() {
        return this.nxj;
    }

    public void gV(Context context) {
        int type;
        int i;
        if (this.nxh != null) {
            int i2 = -1;
            int size = this.nxi.size();
            if (size > 0) {
                try {
                    i2 = this.nxi.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i3 = 0;
            int i4 = i2;
            while (i3 < this.nxh.size()) {
                l lVar = this.nxh.get(i3);
                if (l.dt(i4, lVar.getType())) {
                    this.nxi.get(size - 1).b(lVar.gU(context));
                    i = size;
                    type = i4;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.nxi.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.gU(context));
                        this.nxi.add(lVar2);
                        type = 0;
                    }
                    i = size + 1;
                }
                i3++;
                size = i;
                i4 = type;
            }
        }
    }

    public void gW(Context context) {
        try {
            if (this.nxn != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.nxn.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.nxi == null || this.nxi.size() == 0) {
                gV(context);
            }
            ArrayList<l> arrayList = this.nxi;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dNm() != null) {
                            sb.append((CharSequence) next.dNm());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String CM = TbFaceManager.bCO().CM(next.getText());
                        if (CM != null) {
                            sb.append("[");
                            sb.append(CM);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !au.isEmpty(next.dNl())) {
                        sb.append("[").append(next.dNl()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.id = String.valueOf(subPostList.id);
                this.title = subPostList.title;
                this.floor_num = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = au.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.nxt = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eRz = metaData;
                }
                if (this.eRz.getUserId() == null || this.eRz.getUserId().length() <= 0 || this.eRz.getUserId().equals("0")) {
                    this.eRz = metaData2;
                }
                this.nxn = TbRichTextView.a(context, subPostList.content, z);
                if (this.nxn != null) {
                    this.nxn.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                }
                this.isAuthorView = subPostList.is_author_view.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        TbRichTextData tbRichTextData;
        int i;
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = au.getFormatTime(this.time);
                this.nxg = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eRz = metaData;
                }
                this.jpu = post.need_log.intValue() == 1;
                this.nxE = post.img_num_abtest.intValue() == 1;
                this.nxw = new bx();
                this.nxw.parserProtobuf(post.from_forum);
                if (this.eRz.getUserId() == null || this.eRz.getUserId().length() <= 0 || this.eRz.getUserId().equals("0")) {
                    this.eRz.parserProtobuf(post.author);
                }
                if (this.eRz != null && context != null) {
                    this.nxA = this.eRz.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.nxB = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.eRz.getLevel_id()));
                }
                this.nxq = post.is_ntitle.intValue() == 1;
                this.nxj = post.sub_post_number.intValue();
                this.nxv = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.nxW = post.content;
                this.nxU = post.is_wonderful_post.intValue() == 1;
                this.nxR = post.is_top_agree_post.intValue() == 1;
                this.eOA = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.eTW = post.item;
                }
                if (this.eTW == null && post.outer_item != null && post.outer_item.item_id.longValue() > 0 && com.baidu.tbadk.a.d.bjz()) {
                    this.nxY = post.outer_item;
                }
                this.nxn = TbRichTextView.a(context, list, String.valueOf(post.tid), true);
                if (this.nxn != null) {
                    this.nxn.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.nxn.sj(this.floor_num);
                    if (this.eRz != null) {
                        this.nxn.setAuthorId(this.eRz.getUserId());
                    }
                    int count = y.getCount(this.eOA);
                    if (this.floor_num == 1 && count != 0 && this.eOA != null) {
                        ArrayList<TbRichTextData> bHz = this.nxn.bHz();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) y.getItem(bHz, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                y.add(bHz, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) y.getItem(this.eOA, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.q(com.baidu.tbadk.widget.richText.e.I(i, false));
                            }
                        } else {
                            for (int size = this.eOA.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.eOA.get(size);
                                if (headItem2 != null) {
                                    a(bHz, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.eTW != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.eTW));
                        y.add(this.nxn.bHz(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.nxt = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.ys(this.nxP);
                            postData.a(subPostList, context);
                            this.nxk.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.nxp.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.nxr = new com.baidu.tbadk.data.c();
                    this.nxr.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.nxs = new com.baidu.tbadk.data.g();
                    this.nxs.a(post.lbs_info);
                }
                this.eSh = post.storecount.intValue();
                this.nxo.a(post.present);
                this.eRK.setUserMap(this.userMap);
                this.eRK.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.mih = new SmallTailInfo();
                    this.mih.id = post.signature.signature_id.intValue();
                    this.mih.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.mih.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.mih.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.mih.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.eSt.add(cVar);
                    }
                }
                this.eSw = post.skin_info;
                this.eSz = post.lego_card;
                this.nxC = post.tpoint_post;
                if (post.agree != null) {
                    this.nxD = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.nxD = false;
                }
                this.nxK = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.eTc = new OriginalThreadInfo();
                    this.eTc.a(post.origin_thread_info);
                } else {
                    this.eTc = null;
                }
                this.nxN = post.is_fold.intValue();
                this.lKQ = post.fold_tip;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(headItem.name + ": " + (headItem.type.intValue() == 1 ? headItem.content : " ")));
        if (headItem.type.intValue() == 2) {
            try {
                i = Integer.parseInt(headItem.content);
            } catch (NumberFormatException e) {
                i = 0;
            }
            spannableStringBuilder.append((CharSequence) com.baidu.tbadk.widget.richText.e.I(i, true));
        }
        tbRichTextData.p(spannableStringBuilder);
        y.add(list, 0, tbRichTextData);
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private String mId;
        private String mName;
        private SoftReference<Context> nyf;
        private b nyg;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.nyf = new SoftReference<>(context);
            this.nyg = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.CAM_X0108));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(true);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.nyf != null && this.nyf.get() != null) {
                if (this.nyg != null) {
                    this.nyg.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.nyf.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String gX(Context context) {
        ArrayList<TbRichTextData> bHz;
        if (this.nxn == null || (bHz = this.nxn.bHz()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bHz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bHG().toString());
            } else if (next.getType() == 17) {
                String str = next.bHK().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(R.string.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(R.string.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(R.string.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String dNK() {
        ArrayList<TbRichTextData> bHz;
        String str;
        if (this.nxn == null || (bHz = this.nxn.bHz()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bHz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bHG().toString());
                } else if (next.getType() == 17) {
                    if (next.bHK() != null && next.bHK().mGifInfo != null && (str = next.bHK().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dNL() {
        ArrayList<TbRichTextData> bHz;
        if (this.nxn != null && (bHz = this.nxn.bHz()) != null) {
            Iterator<TbRichTextData> it = bHz.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bHF().getWidth();
                    preLoadImageInfo.height = next.bHF().getHeight();
                    preLoadImageInfo.imgUrl = next.bHF().bHS();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bHL().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bHL().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bHL().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dNM() {
        k dNj;
        PreLoadImageInfo dNL = dNL();
        if (dNL != null && !StringUtils.isNull(dNL.imgUrl)) {
            return dNL.imgUrl;
        }
        if (this.nxv != null && (dNj = this.nxv.dNj()) != null && !StringUtils.isNull(dNj.dNk())) {
            return dNj.dNk();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bHz;
        if (this.nxn == null || (bHz = this.nxn.bHz()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bHz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bHF().getWidth();
                preLoadImageInfo.height = next.bHF().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bHF().bHX()) {
                    preLoadImageInfo.imgUrl = next.bHF().bHT();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bHF().bHS();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bHK() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bHK().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bHK().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bHK();
                preLoadImageInfo2.procType = 20;
                arrayList.add(preLoadImageInfo2);
            }
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bimg_url;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.procType = 19;
            arrayList.add(preLoadImageInfo3);
        }
        if (this.eRz == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.eRz.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.nxf == 52) {
            return nxb;
        }
        if (this.nxf == 1) {
            return eSx;
        }
        if (this.nxf == 36) {
            return eQE;
        }
        if (this.nxf == 40 || this.nxf == 50) {
            return eQK;
        }
        if (this.nxf == 41) {
            return nwZ;
        }
        if (this.nxf == 53) {
            return nxc;
        }
        if (dNF() == 1) {
            return nwX;
        }
        return nwY;
    }

    public void setPostType(int i) {
        this.nxf = i;
    }

    public bb dNN() {
        return this.nxo;
    }

    public void a(bb bbVar) {
        this.nxo = bbVar;
    }

    public i dNO() {
        return this.nxv;
    }

    public com.baidu.tbadk.widget.richText.i bHJ() {
        if (this.nxz != null) {
            return this.nxz;
        }
        if (this.nxn != null && y.getCount(this.nxn.bHz()) > 0) {
            Iterator<TbRichTextData> it = this.nxn.bHz().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.nxz = next.bHJ();
                    return this.nxz;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bHH() {
        if (this.fld != null) {
            return this.fld;
        }
        if (this.nxn != null && y.getCount(this.nxn.bHz()) > 0) {
            Iterator<TbRichTextData> it = this.nxn.bHz().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.fld = next.bHH();
                    return this.fld;
                }
            }
        }
        return null;
    }

    public String dNP() {
        return this.nxA;
    }

    public String bpb() {
        return this.eSz;
    }

    public void bpd() {
        if (this.eRW == 0) {
            this.eRW = 1;
        }
    }

    public long bpr() {
        return this.agreeData.disAgreeNum;
    }

    public int bpt() {
        return this.agreeData.agreeType;
    }

    public AgreeData bpJ() {
        return this.agreeData;
    }

    public OriginalThreadInfo dNQ() {
        return this.eTc;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.eTc = originalThreadInfo;
    }

    public int dNR() {
        return this.nxN;
    }

    public String dlr() {
        return this.lKQ;
    }

    public Item bpW() {
        return this.eTW;
    }

    public List<HeadItem> bpX() {
        return this.eOA;
    }
}
