package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.Agree;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements com.baidu.adp.widget.ListView.m, ae {
    private Agree agree;
    @Deprecated
    private String authorId;
    private SkinInfo bCF;
    private String bCI;
    private long bDi;
    private int bDk;
    private OriginalThreadInfo bDt;
    private TbRichTextVoiceInfo bTm;
    private String bimg_url;
    private SmallTailInfo hDt;
    private String hjN;
    private String hkx;
    private com.baidu.tbadk.data.c iGB;
    private com.baidu.tbadk.data.f iGC;
    private i iGF;
    private bc iGG;
    public boolean iGI;
    private com.baidu.tbadk.widget.richText.f iGJ;
    private String iGK;
    private String iGL;
    private TPointPost iGM;
    public int iGP;
    public AlaLiveInfoCoreData iGU;
    private boolean iGY;
    private ArrayList<PostData> iGu;
    private boolean iHb;
    public am iHd;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId iGi = BdUniqueId.gen();
    public static final BdUniqueId iGj = BdUniqueId.gen();
    public static final BdUniqueId bCG = BdUniqueId.gen();
    public static final BdUniqueId iGk = BdUniqueId.gen();
    public static final BdUniqueId bBb = BdUniqueId.gen();
    public static final BdUniqueId iGl = BdUniqueId.gen();
    public static final BdUniqueId iGm = BdUniqueId.gen();
    public static final BdUniqueId iGn = BdUniqueId.gen();
    public static final BdUniqueId iGo = BdUniqueId.gen();
    public static boolean iGp = false;
    private int iGq = 0;
    private boolean iGv = false;
    private ArrayList<PostData> iGw = null;
    private TbRichText iGx = null;
    private boolean iGA = false;
    private boolean iGD = false;
    private boolean iGE = false;
    public boolean iGH = false;
    public int bCe = 0;
    private boolean iGN = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean fgl = false;
    public boolean iGO = false;
    public boolean iGQ = false;
    public boolean iGR = true;
    public boolean iGS = false;
    public boolean iGT = false;
    private boolean iGV = false;
    private int iGW = 0;
    private boolean iGX = true;
    public boolean iGZ = false;
    public boolean iHa = false;
    public boolean iHc = false;
    private b iHe = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.iHd != null) {
                am adj = PostData.this.iHd.adj();
                adj.delete("obj_locate");
                adj.T("obj_locate", 7);
                TiebaStatic.log(adj);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData bBE = new MetaData();
    private ArrayList<l> iGr = new ArrayList<>();
    private ArrayList<l> iGs = new ArrayList<>();
    private int iGt = 0;
    private int bCp = 0;
    private PraiseData bBR = new PraiseData();
    private ao iGy = new ao();
    private c iGz = new c();
    private ArrayList<com.baidu.tbadk.data.c> bCC = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.iGu = null;
        this.iGP = 0;
        this.iGu = new ArrayList<>();
        this.iGP = 0;
    }

    public void pU(boolean z) {
        this.iGY = z;
    }

    public boolean cei() {
        return this.iGY;
    }

    public ArrayList<PostData> cej() {
        return this.iGw;
    }

    public void cek() {
        this.iGw.clear();
        this.iGw = null;
        this.iGv = false;
    }

    public void r(PostData postData) {
        if (postData != null) {
            if (this.iGw == null) {
                this.iGw = new ArrayList<>();
                if (v.S(this.iGu) > 2) {
                    this.iGw.addAll(v.c(this.iGu, 0, 2));
                } else {
                    this.iGw.addAll(this.iGu);
                }
            }
            this.iGw.add(postData);
        }
    }

    public void s(PostData postData) {
        if (postData != null && this.iGu != null) {
            this.iGu.add(postData);
            ceo();
        }
    }

    public void CA(String str) {
        if (this.iGw != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.iGw.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.iGw.remove(next);
                    return;
                }
            }
        }
    }

    public void pV(boolean z) {
        this.iGX = z;
    }

    public boolean cel() {
        return this.iGX;
    }

    public void pW(boolean z) {
        this.iGv = z;
    }

    public boolean cem() {
        return this.iGv;
    }

    public ArrayList<PostData> cen() {
        return this.iGu;
    }

    public void ceo() {
        this.iGt++;
    }

    public void cep() {
        this.iGt--;
    }

    public void zt(int i) {
        this.iGt = i;
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

    public String bHT() {
        return this.hjN;
    }

    public int ceq() {
        return this.floor_num;
    }

    public void zu(int i) {
        this.floor_num = i;
    }

    public boolean cer() {
        return this.iGE;
    }

    public void pX(boolean z) {
        this.iGE = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ap.ao(j);
    }

    public MetaData YR() {
        return this.bBE;
    }

    public void a(MetaData metaData) {
        this.bBE = metaData;
    }

    public void a(PraiseData praiseData) {
        this.bBR = praiseData;
    }

    public TbRichText ces() {
        return this.iGx;
    }

    public void c(TbRichText tbRichText) {
        this.iGx = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bON() {
        return this.hDt;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.hDt = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cet() {
        return this.iGC;
    }

    public SkinInfo Zm() {
        return this.bCF;
    }

    public void pY(boolean z) {
        this.iGV = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.iGx != null && this.iGx.asw() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.bBE != null && this.bBE.getIs_bawu() == 1) {
                    if (this.iGY) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.bBE.getBawu_type())) {
                        str = " 吧主";
                    } else if ("assist".equals(this.bBE.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.bBE.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.bBE.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = YR().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jB().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.jB().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.oz()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.iGx.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.d(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.bBE.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.bBE.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.bBE == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.bBE.getName_show() + str + "：");
                str2 = this.bBE.getUserName();
                str3 = this.bBE.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.bBE.getSealPrefix())) {
                Bitmap hq = al.hq(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(hq);
                if (hq != null) {
                    bitmapDrawable.setBounds(0, 0, hq.getWidth(), hq.getHeight());
                }
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.bBE.getSealPrefix().length() + 1;
                spannableString.setSpan(kVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.iHe), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.bBE != null && this.bBE.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.c ak = ak(z, this.bBE != null && this.bBE.getIs_bawu() == 1);
                if (ak != null) {
                    if (this.bBE != null) {
                        int i3 = 0;
                        if (this.bBE.getName_show() != null) {
                            i3 = this.bBE.getName_show().length();
                        }
                        spannableString.setSpan(ak, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(ak, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> asw = this.iGx.asw();
            if (asw != null && asw.size() > 0) {
                TbRichTextData tbRichTextData2 = asw.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.asE() != null) {
                    if (this.iGV) {
                        int indexOf = tbRichTextData2.asE().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.asE().delete(0, indexOf + 1);
                        }
                        this.iGV = false;
                    }
                    tbRichTextData2.kK(sb.length());
                    tbRichTextData2.asE().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= asw.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (asw.get(i5) == null || asw.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo asF = asw.get(i5).asF();
                            asw.remove(i5);
                            tbRichTextVoiceInfo = asF;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.kK(sb.length());
                    tbRichTextData.append(spannableString);
                    asw.add(0, tbRichTextData);
                }
            }
            this.iGZ = true;
        }
    }

    private com.baidu.tbadk.core.view.c ak(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c(com.baidu.adp.lib.util.l.h(context, d.e.tbds1), com.baidu.adp.lib.util.l.h(context, d.e.tbds5), this.iGY ? d.C0236d.cp_link_tip_a_alpha50 : d.C0236d.cp_link_tip_a, com.baidu.adp.lib.util.l.h(context, d.e.tbds26), this.iGY ? d.C0236d.cp_link_tip_a : d.C0236d.cp_bg_line_d, com.baidu.adp.lib.util.l.h(context, d.e.tbds12), com.baidu.adp.lib.util.l.h(context, d.e.tbds40));
        if (this.iGY) {
            cVar.dL(false);
            return cVar;
        }
        cVar.dL(true);
        return cVar;
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap oy;
        if (aVar == null || (oy = aVar.oy()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(oy);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36));
        return bitmapDrawable;
    }

    public int ceu() {
        return this.iGt;
    }

    public void eu(Context context) {
        int type;
        int i;
        int i2;
        if (this.iGr != null) {
            int i3 = -1;
            int size = this.iGs.size();
            if (size > 0) {
                try {
                    i3 = this.iGs.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.iGr.size()) {
                l lVar = this.iGr.get(i4);
                if (l.co(i5, lVar.getType())) {
                    this.iGs.get(size - 1).b(lVar.et(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.iGs.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.et(context));
                        this.iGs.add(lVar2);
                        type = 0;
                    }
                    i = type;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void ev(Context context) {
        try {
            if (this.iGx != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.iGx.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.iGs == null || this.iGs.size() == 0) {
                eu(context);
            }
            ArrayList<l> arrayList = this.iGs;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.ceb() != null) {
                            sb.append((CharSequence) next.ceb());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.j.voice_str));
                    } else if (next.getType() == 2) {
                        String oI = TbFaceManager.anp().oI(next.getText());
                        if (oI != null) {
                            sb.append("[");
                            sb.append(oI);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ap.isEmpty(next.cea())) {
                        sb.append("[").append(next.cea()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
            }
        } catch (NullPointerException e) {
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
                this.date = ap.ao(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.iGD = subPostList.is_giftpost.intValue() == 1;
                this.agree = subPostList.agree;
                if (this.agree != null) {
                    this.bDk = this.agree.agree_type.intValue();
                    this.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeNum = this.agree.agree_num.longValue() > 0 ? this.agree.agree_num.longValue() : 0L;
                    this.bDi = this.agree.disagree_num.longValue() > 0 ? this.agree.disagree_num.longValue() : 0L;
                    this.agreeData.postId = this.id;
                    this.agreeData.agreeNum = this.agree.agree_num.longValue();
                    this.agreeData.disAgreeNum = this.agree.disagree_num.longValue();
                    this.agreeData.agreeType = this.agree.agree_type == null ? 0 : this.agree.agree_type.intValue();
                    this.agreeData.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeData.diffAgreeNum = this.agree.diff_agree_num != null ? this.agree.diff_agree_num.longValue() : 0L;
                }
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bBE = metaData;
                }
                if ((this.bBE.getUserId() == null || this.bBE.getUserId().length() <= 0 || this.bBE.getUserId().equals("0")) && metaData2 != null) {
                    this.bBE = metaData2;
                }
                this.iGx = TbRichTextView.a(context, subPostList.content, z);
                if (this.iGx != null) {
                    this.iGx.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = ap.ao(this.time);
                this.hjN = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bBE = metaData;
                }
                this.fgl = post.need_log.intValue() == 1;
                this.iGO = post.img_num_abtest.intValue() == 1;
                this.iGG = new bc();
                this.iGG.parserProtobuf(post.from_forum);
                if (this.bBE.getUserId() == null || this.bBE.getUserId().length() <= 0 || this.bBE.getUserId().equals("0")) {
                    this.bBE.parserProtobuf(post.author);
                }
                if (this.bBE != null && context != null) {
                    this.iGK = this.bBE.getUserName() + context.getResources().getString(d.j.somebodys_portrait);
                    this.iGL = String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(this.bBE.getLevel_id()));
                }
                this.iGA = post.is_ntitle.intValue() == 1;
                this.iGt = post.sub_post_number.intValue();
                this.iGF = new i(post.tpoint_post);
                this.iGx = TbRichTextView.a(context, post.content, true);
                if (this.iGx != null) {
                    this.iGx.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
                    this.iGx.kJ(this.floor_num);
                    if (this.bBE != null) {
                        this.iGx.setAuthorId(this.bBE.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.iGD = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.pU(this.iGY);
                            postData.a(subPostList, context);
                            this.iGu.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.iGz.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.iGB = new com.baidu.tbadk.data.c();
                    this.iGB.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.iGC = new com.baidu.tbadk.data.f();
                    this.iGC.a(post.lbs_info);
                }
                this.bCp = post.storecount.intValue();
                this.iGy.a(post.present);
                this.bBR.setUserMap(this.userMap);
                this.bBR.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.hDt = new SmallTailInfo();
                    this.hDt.id = post.signature.signature_id.intValue();
                    this.hDt.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.hDt.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.hDt.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.hDt.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.bCC.add(cVar);
                    }
                }
                this.bCF = post.skin_info;
                this.bCI = post.lego_card;
                this.iGM = post.tpoint_post;
                if (post.agree != null) {
                    this.iGN = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                    if (post.agree.disagree_num.longValue() >= 0) {
                        this.bDi = post.agree.disagree_num.longValue();
                    } else {
                        this.bDi = 0L;
                    }
                    this.bDk = post.agree.agree_type.intValue();
                    this.agreeData.postId = this.id;
                    this.agreeData.agreeType = post.agree.agree_type == null ? 0 : post.agree.agree_type.intValue();
                    this.agreeData.hasAgree = post.agree.has_agree.intValue() == 1;
                    this.agreeData.agreeNum = this.agreeNum;
                    this.agreeData.disAgreeNum = this.bDi;
                    this.agreeData.diffAgreeNum = post.agree.diff_agree_num == null ? 0L : post.agree.diff_agree_num.longValue();
                } else {
                    this.iGN = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.bDi < 0) {
                    this.bDi = 0L;
                }
                this.iGT = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.bDt = new OriginalThreadInfo();
                    this.bDt.parser(post.origin_thread_info);
                } else {
                    this.bDt = null;
                }
                this.iGW = post.is_fold.intValue();
                this.hkx = post.fold_tip;
                this.iHa = post.is_top_agree_post.intValue() == 1;
                this.iHb = post.show_squared.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int hBr;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(this.hBr));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> iHk;
        private b iHl;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.iHk = new SoftReference<>(context);
            this.iHl = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(d.C0236d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.iHk != null) {
                if (this.iHl != null) {
                    this.iHl.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.iHk.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String ew(Context context) {
        ArrayList<TbRichTextData> asw;
        if (this.iGx == null || (asw = this.iGx.asw()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = asw.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.asE().toString());
            } else if (next.getType() == 17) {
                String str = next.asI().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(d.j.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(d.j.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(d.j.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String cev() {
        ArrayList<TbRichTextData> asw;
        String str;
        if (this.iGx == null || (asw = this.iGx.asw()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = asw.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.asE().toString());
                } else if (next.getType() == 17) {
                    if (next.asI() != null && next.asI().mGifInfo != null && (str = next.asI().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cew() {
        ArrayList<TbRichTextData> asw;
        if (this.iGx != null && (asw = this.iGx.asw()) != null) {
            Iterator<TbRichTextData> it = asw.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.asD().getWidth();
                    preLoadImageInfo.height = next.asD().getHeight();
                    preLoadImageInfo.imgUrl = next.asD().asR();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.asJ().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.asJ().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.asJ().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cex() {
        k cdT;
        PreLoadImageInfo cew = cew();
        if (cew != null && !StringUtils.isNull(cew.imgUrl)) {
            return cew.imgUrl;
        }
        if (this.iGF != null && (cdT = this.iGF.cdT()) != null && !StringUtils.isNull(cdT.cdY())) {
            return cdT.cdY();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> asw;
        if (this.iGx == null || (asw = this.iGx.asw()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = asw.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.asD().getWidth();
                preLoadImageInfo.height = next.asD().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.asD().asW()) {
                    preLoadImageInfo.imgUrl = next.asD().asS();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.asD().asR();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.asI() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.asI().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.asI().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.asI();
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
        if (this.bBE == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.bBE.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.iGq == 52) {
            return iGm;
        }
        if (this.iGq == 1) {
            return bCG;
        }
        if (this.iGq == 36) {
            return iGk;
        }
        if (this.iGq == 40 || this.iGq == 50) {
            return bBb;
        }
        if (this.iGq == 41) {
            return iGl;
        }
        if (this.iGq == 53) {
            return iGn;
        }
        if (ceq() == 1) {
            return iGi;
        }
        return iGj;
    }

    public void setPostType(int i) {
        this.iGq = i;
    }

    public ao cey() {
        return this.iGy;
    }

    public void a(ao aoVar) {
        this.iGy = aoVar;
    }

    public i cez() {
        return this.iGF;
    }

    public com.baidu.tbadk.widget.richText.f asH() {
        if (this.iGJ != null) {
            return this.iGJ;
        }
        if (this.iGx != null && v.S(this.iGx.asw()) > 0) {
            Iterator<TbRichTextData> it = this.iGx.asw().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.iGJ = next.asH();
                    return this.iGJ;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo asF() {
        if (this.bTm != null) {
            return this.bTm;
        }
        if (this.iGx != null && v.S(this.iGx.asw()) > 0) {
            Iterator<TbRichTextData> it = this.iGx.asw().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.bTm = next.asF();
                    return this.bTm;
                }
            }
        }
        return null;
    }

    public String ceA() {
        return this.iGK;
    }

    public String ZT() {
        return this.bCI;
    }

    public void ZV() {
        if (this.bCe == 0) {
            this.bCe = 1;
        }
    }

    public long aak() {
        return this.agreeNum;
    }

    public long aal() {
        return this.bDi;
    }

    public void af(long j) {
        this.agreeNum = j;
    }

    public boolean beW() {
        return this.hasAgree;
    }

    public void gA(int i) {
        this.bDk = i;
    }

    public void pZ(boolean z) {
        this.hasAgree = z;
    }

    public int aan() {
        return this.bDk;
    }

    public void ag(long j) {
        this.bDi = j;
    }

    public AgreeData aaH() {
        return this.agreeData;
    }

    public OriginalThreadInfo ceB() {
        return this.bDt;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.bDt = originalThreadInfo;
    }

    public int ceC() {
        return this.iGW;
    }

    public String bIh() {
        return this.hkx;
    }

    public boolean ceD() {
        return this.iHb;
    }
}
