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
import com.baidu.tieba.R;
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
    private long bKE;
    private int bKG;
    private OriginalThreadInfo bKP;
    private SkinInfo bKb;
    private String bKe;
    private String bimg_url;
    private TbRichTextVoiceInfo cbi;
    private String hAT;
    private String hBE;
    private SmallTailInfo hVb;
    private ArrayList<PostData> iYN;
    private com.baidu.tbadk.data.c iYU;
    private com.baidu.tbadk.data.f iYV;
    private i iYY;
    private bc iYZ;
    public boolean iZb;
    private com.baidu.tbadk.widget.richText.f iZc;
    private String iZd;
    private String iZe;
    private TPointPost iZf;
    public int iZi;
    public AlaLiveInfoCoreData iZn;
    private boolean iZr;
    private boolean iZu;
    public am iZw;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId iYz = BdUniqueId.gen();
    public static final BdUniqueId iYA = BdUniqueId.gen();
    public static final BdUniqueId bKc = BdUniqueId.gen();
    public static final BdUniqueId iYB = BdUniqueId.gen();
    public static final BdUniqueId bIw = BdUniqueId.gen();
    public static final BdUniqueId iYC = BdUniqueId.gen();
    public static final BdUniqueId iYD = BdUniqueId.gen();
    public static final BdUniqueId iYE = BdUniqueId.gen();
    public static final BdUniqueId iYF = BdUniqueId.gen();
    public static final BdUniqueId iYG = BdUniqueId.gen();
    public static boolean iYH = false;
    private int iYI = 0;
    private boolean iYO = false;
    private ArrayList<PostData> iYP = null;
    private TbRichText iYQ = null;
    private boolean iYT = false;
    private boolean iYW = false;
    private boolean iYX = false;
    public boolean iZa = false;
    public int bJA = 0;
    private boolean iZg = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean fwk = false;
    public boolean iZh = false;
    public boolean iZj = false;
    public boolean iZk = true;
    public boolean iZl = false;
    public boolean iZm = false;
    private boolean iZo = false;
    private int iZp = 0;
    private boolean iZq = true;
    public boolean iZs = false;
    public boolean iZt = false;
    public boolean iZv = false;
    private b iZx = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.iZw != null) {
                am aie = PostData.this.iZw.aie();
                aie.delete("obj_locate");
                aie.P("obj_locate", 7);
                TiebaStatic.log(aie);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int iYJ = 0;
    private long time = 0;
    private String date = null;
    private MetaData bJa = new MetaData();
    private ArrayList<l> iYK = new ArrayList<>();
    private ArrayList<l> iYL = new ArrayList<>();
    private int iYM = 0;
    private int bJL = 0;
    private PraiseData bJn = new PraiseData();
    private ao iYR = new ao();
    private c iYS = new c();
    private ArrayList<com.baidu.tbadk.data.c> bJY = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.iYN = null;
        this.iZi = 0;
        this.iYN = new ArrayList<>();
        this.iZi = 0;
    }

    public void qJ(boolean z) {
        this.iZr = z;
    }

    public boolean cmm() {
        return this.iZr;
    }

    public ArrayList<PostData> cmn() {
        return this.iYP;
    }

    public void cmo() {
        this.iYP.clear();
        this.iYP = null;
        this.iYO = false;
    }

    public void r(PostData postData) {
        if (postData != null) {
            if (this.iYP == null) {
                this.iYP = new ArrayList<>();
                if (v.Z(this.iYN) > 2) {
                    this.iYP.addAll(v.c(this.iYN, 0, 2));
                } else {
                    this.iYP.addAll(this.iYN);
                }
            }
            this.iYP.add(postData);
        }
    }

    public void s(PostData postData) {
        if (postData != null && this.iYN != null) {
            this.iYN.add(postData);
            cms();
        }
    }

    public void DU(String str) {
        if (this.iYP != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.iYP.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.iYP.remove(next);
                    return;
                }
            }
        }
    }

    public void qK(boolean z) {
        this.iZq = z;
    }

    public boolean cmp() {
        return this.iZq;
    }

    public void qL(boolean z) {
        this.iYO = z;
    }

    public boolean cmq() {
        return this.iYO;
    }

    public ArrayList<PostData> cmr() {
        return this.iYN;
    }

    public void cms() {
        this.iYM++;
    }

    public void cmt() {
        this.iYM--;
    }

    public void Ax(int i) {
        this.iYM = i;
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

    public String bPC() {
        return this.hAT;
    }

    public int cmu() {
        return this.iYJ;
    }

    public void Ay(int i) {
        this.iYJ = i;
    }

    public boolean cmv() {
        return this.iYX;
    }

    public void qM(boolean z) {
        this.iYX = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ap.aC(j);
    }

    public MetaData adv() {
        return this.bJa;
    }

    public void a(MetaData metaData) {
        this.bJa = metaData;
    }

    public void a(PraiseData praiseData) {
        this.bJn = praiseData;
    }

    public TbRichText cmw() {
        return this.iYQ;
    }

    public void c(TbRichText tbRichText) {
        this.iYQ = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bWE() {
        return this.hVb;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.hVb = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cmx() {
        return this.iYV;
    }

    public SkinInfo adQ() {
        return this.bKb;
    }

    public void qN(boolean z) {
        this.iZo = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.iYQ != null && this.iYQ.axy() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.bJa != null && this.bJa.getIs_bawu() == 1) {
                    if (this.iZr) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.bJa.getBawu_type())) {
                        str = " 吧主";
                    } else if ("assist".equals(this.bJa.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.bJa.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.bJa.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = adv().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.iv().b(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.iv().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.nt()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.iYQ.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.c(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.bJa.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.bJa.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.bJa == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.bJa.getName_show() + str + "：");
                str2 = this.bJa.getUserName();
                str3 = this.bJa.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.bJa.getSealPrefix())) {
                Bitmap id = al.id(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(id);
                if (id != null) {
                    bitmapDrawable.setBounds(0, 0, id.getWidth(), id.getHeight());
                }
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.bJa.getSealPrefix().length() + 1;
                spannableString.setSpan(kVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.iZx), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.bJa != null && this.bJa.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.c aj = aj(z, this.bJa != null && this.bJa.getIs_bawu() == 1);
                if (aj != null) {
                    if (this.bJa != null) {
                        int i3 = 0;
                        if (this.bJa.getName_show() != null) {
                            i3 = this.bJa.getName_show().length();
                        }
                        spannableString.setSpan(aj, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(aj, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> axy = this.iYQ.axy();
            if (axy != null && axy.size() > 0) {
                TbRichTextData tbRichTextData2 = axy.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.axG() != null) {
                    if (this.iZo) {
                        int indexOf = tbRichTextData2.axG().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.axG().delete(0, indexOf + 1);
                        }
                        this.iZo = false;
                    }
                    tbRichTextData2.ly(sb.length());
                    tbRichTextData2.axG().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= axy.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (axy.get(i5) == null || axy.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo axH = axy.get(i5).axH();
                            axy.remove(i5);
                            tbRichTextVoiceInfo = axH;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.ly(sb.length());
                    tbRichTextData.append(spannableString);
                    axy.add(0, tbRichTextData);
                }
            }
            this.iZs = true;
        }
    }

    private com.baidu.tbadk.core.view.c aj(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds5), this.iZr ? R.color.cp_link_tip_a_alpha50 : R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds26), this.iZr ? R.color.cp_link_tip_a : R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds40));
        if (this.iZr) {
            cVar.eh(false);
            return cVar;
        }
        cVar.eh(true);
        return cVar;
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap ns;
        if (aVar == null || (ns = aVar.ns()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ns);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36));
        return bitmapDrawable;
    }

    public int cmy() {
        return this.iYM;
    }

    public void ej(Context context) {
        int type;
        int i;
        int i2;
        if (this.iYK != null) {
            int i3 = -1;
            int size = this.iYL.size();
            if (size > 0) {
                try {
                    i3 = this.iYL.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.iYK.size()) {
                l lVar = this.iYK.get(i4);
                if (l.cv(i5, lVar.getType())) {
                    this.iYL.get(size - 1).b(lVar.ei(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.iYL.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.ei(context));
                        this.iYL.add(lVar2);
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

    public void ek(Context context) {
        try {
            if (this.iYQ != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.iYQ.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.iYL == null || this.iYL.size() == 0) {
                ej(context);
            }
            ArrayList<l> arrayList = this.iYL;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cmf() != null) {
                            sb.append((CharSequence) next.cmf());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String pR = TbFaceManager.aso().pR(next.getText());
                        if (pR != null) {
                            sb.append("[");
                            sb.append(pR);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ap.isEmpty(next.cme())) {
                        sb.append("[").append(next.cme()).append("]");
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
                this.iYJ = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = ap.aC(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.iYW = subPostList.is_giftpost.intValue() == 1;
                this.agree = subPostList.agree;
                if (this.agree != null) {
                    this.bKG = this.agree.agree_type.intValue();
                    this.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeNum = this.agree.agree_num.longValue() > 0 ? this.agree.agree_num.longValue() : 0L;
                    this.bKE = this.agree.disagree_num.longValue() > 0 ? this.agree.disagree_num.longValue() : 0L;
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
                    this.bJa = metaData;
                }
                if ((this.bJa.getUserId() == null || this.bJa.getUserId().length() <= 0 || this.bJa.getUserId().equals("0")) && metaData2 != null) {
                    this.bJa = metaData2;
                }
                this.iYQ = TbRichTextView.a(context, subPostList.content, z);
                if (this.iYQ != null) {
                    this.iYQ.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.iYJ = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = ap.aC(this.time);
                this.hAT = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bJa = metaData;
                }
                this.fwk = post.need_log.intValue() == 1;
                this.iZh = post.img_num_abtest.intValue() == 1;
                this.iYZ = new bc();
                this.iYZ.parserProtobuf(post.from_forum);
                if (this.bJa.getUserId() == null || this.bJa.getUserId().length() <= 0 || this.bJa.getUserId().equals("0")) {
                    this.bJa.parserProtobuf(post.author);
                }
                if (this.bJa != null && context != null) {
                    this.iZd = this.bJa.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.iZe = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.bJa.getLevel_id()));
                }
                this.iYT = post.is_ntitle.intValue() == 1;
                this.iYM = post.sub_post_number.intValue();
                this.iYY = new i(post.tpoint_post);
                this.iYQ = TbRichTextView.a(context, post.content, true);
                if (this.iYQ != null) {
                    this.iYQ.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.iYQ.lx(this.iYJ);
                    if (this.bJa != null) {
                        this.iYQ.setAuthorId(this.bJa.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.iYW = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.qJ(this.iZr);
                            postData.a(subPostList, context);
                            this.iYN.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.iYS.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.iYU = new com.baidu.tbadk.data.c();
                    this.iYU.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.iYV = new com.baidu.tbadk.data.f();
                    this.iYV.a(post.lbs_info);
                }
                this.bJL = post.storecount.intValue();
                this.iYR.a(post.present);
                this.bJn.setUserMap(this.userMap);
                this.bJn.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.hVb = new SmallTailInfo();
                    this.hVb.id = post.signature.signature_id.intValue();
                    this.hVb.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.hVb.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.hVb.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.hVb.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.bJY.add(cVar);
                    }
                }
                this.bKb = post.skin_info;
                this.bKe = post.lego_card;
                this.iZf = post.tpoint_post;
                if (post.agree != null) {
                    this.iZg = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                    if (post.agree.disagree_num.longValue() >= 0) {
                        this.bKE = post.agree.disagree_num.longValue();
                    } else {
                        this.bKE = 0L;
                    }
                    this.bKG = post.agree.agree_type.intValue();
                    this.agreeData.postId = this.id;
                    this.agreeData.agreeType = post.agree.agree_type == null ? 0 : post.agree.agree_type.intValue();
                    this.agreeData.hasAgree = post.agree.has_agree.intValue() == 1;
                    this.agreeData.agreeNum = this.agreeNum;
                    this.agreeData.disAgreeNum = this.bKE;
                    this.agreeData.diffAgreeNum = post.agree.diff_agree_num == null ? 0L : post.agree.diff_agree_num.longValue();
                } else {
                    this.iZg = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.bKE < 0) {
                    this.bKE = 0L;
                }
                this.iZm = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.bKP = new OriginalThreadInfo();
                    this.bKP.parser(post.origin_thread_info);
                } else {
                    this.bKP = null;
                }
                this.iZp = post.is_fold.intValue();
                this.hBE = post.fold_tip;
                this.iZt = post.is_top_agree_post.intValue() == 1;
                this.iZu = post.show_squared.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int hTa;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(this.hTa));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> iZD;
        private b iZE;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.iZD = new SoftReference<>(context);
            this.iZE = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.iZD != null) {
                if (this.iZE != null) {
                    this.iZE.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.iZD.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String el(Context context) {
        ArrayList<TbRichTextData> axy;
        if (this.iYQ == null || (axy = this.iYQ.axy()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = axy.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.axG().toString());
            } else if (next.getType() == 17) {
                String str = next.axK().mGifInfo.mSharpText;
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

    public String cmz() {
        ArrayList<TbRichTextData> axy;
        String str;
        if (this.iYQ == null || (axy = this.iYQ.axy()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = axy.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.axG().toString());
                } else if (next.getType() == 17) {
                    if (next.axK() != null && next.axK().mGifInfo != null && (str = next.axK().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cmA() {
        ArrayList<TbRichTextData> axy;
        if (this.iYQ != null && (axy = this.iYQ.axy()) != null) {
            Iterator<TbRichTextData> it = axy.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.axF().getWidth();
                    preLoadImageInfo.height = next.axF().getHeight();
                    preLoadImageInfo.imgUrl = next.axF().axT();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.axL().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.axL().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.axL().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cmB() {
        k clX;
        PreLoadImageInfo cmA = cmA();
        if (cmA != null && !StringUtils.isNull(cmA.imgUrl)) {
            return cmA.imgUrl;
        }
        if (this.iYY != null && (clX = this.iYY.clX()) != null && !StringUtils.isNull(clX.cmc())) {
            return clX.cmc();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> axy;
        if (this.iYQ == null || (axy = this.iYQ.axy()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = axy.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.axF().getWidth();
                preLoadImageInfo.height = next.axF().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.axF().axY()) {
                    preLoadImageInfo.imgUrl = next.axF().axU();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.axF().axT();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.axK() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.axK().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.axK().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.axK();
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
        if (this.bJa == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.bJa.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.iYI == 52) {
            return iYE;
        }
        if (this.iYI == 1) {
            return bKc;
        }
        if (this.iYI == 36) {
            return iYB;
        }
        if (this.iYI == 40 || this.iYI == 50) {
            return bIw;
        }
        if (this.iYI == 41) {
            return iYC;
        }
        if (this.iYI == 53) {
            return iYF;
        }
        if (cmu() == 1) {
            return iYz;
        }
        return iYA;
    }

    public void setPostType(int i) {
        this.iYI = i;
    }

    public ao cmC() {
        return this.iYR;
    }

    public void a(ao aoVar) {
        this.iYR = aoVar;
    }

    public i cmD() {
        return this.iYY;
    }

    public com.baidu.tbadk.widget.richText.f axJ() {
        if (this.iZc != null) {
            return this.iZc;
        }
        if (this.iYQ != null && v.Z(this.iYQ.axy()) > 0) {
            Iterator<TbRichTextData> it = this.iYQ.axy().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.iZc = next.axJ();
                    return this.iZc;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo axH() {
        if (this.cbi != null) {
            return this.cbi;
        }
        if (this.iYQ != null && v.Z(this.iYQ.axy()) > 0) {
            Iterator<TbRichTextData> it = this.iYQ.axy().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.cbi = next.axH();
                    return this.cbi;
                }
            }
        }
        return null;
    }

    public String cmE() {
        return this.iZd;
    }

    public String aex() {
        return this.bKe;
    }

    public void aez() {
        if (this.bJA == 0) {
            this.bJA = 1;
        }
    }

    public long aeO() {
        return this.agreeNum;
    }

    public long aeP() {
        return this.bKE;
    }

    public void ar(long j) {
        this.agreeNum = j;
    }

    public boolean bmm() {
        return this.hasAgree;
    }

    public void hl(int i) {
        this.bKG = i;
    }

    public void qO(boolean z) {
        this.hasAgree = z;
    }

    public int aeR() {
        return this.bKG;
    }

    public void as(long j) {
        this.bKE = j;
    }

    public AgreeData afl() {
        return this.agreeData;
    }

    public OriginalThreadInfo cmF() {
        return this.bKP;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.bKP = originalThreadInfo;
    }

    public int cmG() {
        return this.iZp;
    }

    public String bPQ() {
        return this.hBE;
    }

    public boolean cmH() {
        return this.iZu;
    }
}
