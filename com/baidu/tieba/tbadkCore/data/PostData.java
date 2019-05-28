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
    private String hAW;
    private String hBH;
    private SmallTailInfo hVe;
    private ArrayList<PostData> iYP;
    private com.baidu.tbadk.data.c iYW;
    private com.baidu.tbadk.data.f iYX;
    private i iZa;
    private bc iZb;
    public boolean iZd;
    private com.baidu.tbadk.widget.richText.f iZe;
    private String iZf;
    private String iZg;
    private TPointPost iZh;
    public int iZk;
    public AlaLiveInfoCoreData iZp;
    private boolean iZt;
    private boolean iZw;
    public am iZy;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId iYB = BdUniqueId.gen();
    public static final BdUniqueId iYC = BdUniqueId.gen();
    public static final BdUniqueId bKc = BdUniqueId.gen();
    public static final BdUniqueId iYD = BdUniqueId.gen();
    public static final BdUniqueId bIw = BdUniqueId.gen();
    public static final BdUniqueId iYE = BdUniqueId.gen();
    public static final BdUniqueId iYF = BdUniqueId.gen();
    public static final BdUniqueId iYG = BdUniqueId.gen();
    public static final BdUniqueId iYH = BdUniqueId.gen();
    public static final BdUniqueId iYI = BdUniqueId.gen();
    public static boolean iYJ = false;
    private int iYK = 0;
    private boolean iYQ = false;
    private ArrayList<PostData> iYR = null;
    private TbRichText iYS = null;
    private boolean iYV = false;
    private boolean iYY = false;
    private boolean iYZ = false;
    public boolean iZc = false;
    public int bJA = 0;
    private boolean iZi = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean fwl = false;
    public boolean iZj = false;
    public boolean iZl = false;
    public boolean iZm = true;
    public boolean iZn = false;
    public boolean iZo = false;
    private boolean iZq = false;
    private int iZr = 0;
    private boolean iZs = true;
    public boolean iZu = false;
    public boolean iZv = false;
    public boolean iZx = false;
    private b iZz = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.iZy != null) {
                am aie = PostData.this.iZy.aie();
                aie.delete("obj_locate");
                aie.P("obj_locate", 7);
                TiebaStatic.log(aie);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int iYL = 0;
    private long time = 0;
    private String date = null;
    private MetaData bJa = new MetaData();
    private ArrayList<l> iYM = new ArrayList<>();
    private ArrayList<l> iYN = new ArrayList<>();
    private int iYO = 0;
    private int bJL = 0;
    private PraiseData bJn = new PraiseData();
    private ao iYT = new ao();
    private c iYU = new c();
    private ArrayList<com.baidu.tbadk.data.c> bJY = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.iYP = null;
        this.iZk = 0;
        this.iYP = new ArrayList<>();
        this.iZk = 0;
    }

    public void qJ(boolean z) {
        this.iZt = z;
    }

    public boolean cmo() {
        return this.iZt;
    }

    public ArrayList<PostData> cmp() {
        return this.iYR;
    }

    public void cmq() {
        this.iYR.clear();
        this.iYR = null;
        this.iYQ = false;
    }

    public void r(PostData postData) {
        if (postData != null) {
            if (this.iYR == null) {
                this.iYR = new ArrayList<>();
                if (v.Z(this.iYP) > 2) {
                    this.iYR.addAll(v.c(this.iYP, 0, 2));
                } else {
                    this.iYR.addAll(this.iYP);
                }
            }
            this.iYR.add(postData);
        }
    }

    public void s(PostData postData) {
        if (postData != null && this.iYP != null) {
            this.iYP.add(postData);
            cmu();
        }
    }

    public void DU(String str) {
        if (this.iYR != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.iYR.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.iYR.remove(next);
                    return;
                }
            }
        }
    }

    public void qK(boolean z) {
        this.iZs = z;
    }

    public boolean cmr() {
        return this.iZs;
    }

    public void qL(boolean z) {
        this.iYQ = z;
    }

    public boolean cms() {
        return this.iYQ;
    }

    public ArrayList<PostData> cmt() {
        return this.iYP;
    }

    public void cmu() {
        this.iYO++;
    }

    public void cmv() {
        this.iYO--;
    }

    public void Ax(int i) {
        this.iYO = i;
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

    public String bPF() {
        return this.hAW;
    }

    public int cmw() {
        return this.iYL;
    }

    public void Ay(int i) {
        this.iYL = i;
    }

    public boolean cmx() {
        return this.iYZ;
    }

    public void qM(boolean z) {
        this.iYZ = z;
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

    public TbRichText cmy() {
        return this.iYS;
    }

    public void c(TbRichText tbRichText) {
        this.iYS = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bWH() {
        return this.hVe;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.hVe = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cmz() {
        return this.iYX;
    }

    public SkinInfo adQ() {
        return this.bKb;
    }

    public void qN(boolean z) {
        this.iZq = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.iYS != null && this.iYS.axz() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.bJa != null && this.bJa.getIs_bawu() == 1) {
                    if (this.iZt) {
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
                                            PostData.this.iYS.isChanged = true;
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
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.iZz), 0, spannableString.length(), 18);
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
            ArrayList<TbRichTextData> axz = this.iYS.axz();
            if (axz != null && axz.size() > 0) {
                TbRichTextData tbRichTextData2 = axz.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.axH() != null) {
                    if (this.iZq) {
                        int indexOf = tbRichTextData2.axH().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.axH().delete(0, indexOf + 1);
                        }
                        this.iZq = false;
                    }
                    tbRichTextData2.ly(sb.length());
                    tbRichTextData2.axH().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= axz.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (axz.get(i5) == null || axz.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo axI = axz.get(i5).axI();
                            axz.remove(i5);
                            tbRichTextVoiceInfo = axI;
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
                    axz.add(0, tbRichTextData);
                }
            }
            this.iZu = true;
        }
    }

    private com.baidu.tbadk.core.view.c aj(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds5), this.iZt ? R.color.cp_link_tip_a_alpha50 : R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds26), this.iZt ? R.color.cp_link_tip_a : R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds40));
        if (this.iZt) {
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

    public int cmA() {
        return this.iYO;
    }

    public void ej(Context context) {
        int type;
        int i;
        int i2;
        if (this.iYM != null) {
            int i3 = -1;
            int size = this.iYN.size();
            if (size > 0) {
                try {
                    i3 = this.iYN.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.iYM.size()) {
                l lVar = this.iYM.get(i4);
                if (l.cv(i5, lVar.getType())) {
                    this.iYN.get(size - 1).b(lVar.ei(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.iYN.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.ei(context));
                        this.iYN.add(lVar2);
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
            if (this.iYS != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.iYS.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.iYN == null || this.iYN.size() == 0) {
                ej(context);
            }
            ArrayList<l> arrayList = this.iYN;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cmh() != null) {
                            sb.append((CharSequence) next.cmh());
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
                    } else if (next.getType() == 11 && !ap.isEmpty(next.cmg())) {
                        sb.append("[").append(next.cmg()).append("]");
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
                this.iYL = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = ap.aC(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.iYY = subPostList.is_giftpost.intValue() == 1;
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
                this.iYS = TbRichTextView.a(context, subPostList.content, z);
                if (this.iYS != null) {
                    this.iYS.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.iYL = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = ap.aC(this.time);
                this.hAW = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bJa = metaData;
                }
                this.fwl = post.need_log.intValue() == 1;
                this.iZj = post.img_num_abtest.intValue() == 1;
                this.iZb = new bc();
                this.iZb.parserProtobuf(post.from_forum);
                if (this.bJa.getUserId() == null || this.bJa.getUserId().length() <= 0 || this.bJa.getUserId().equals("0")) {
                    this.bJa.parserProtobuf(post.author);
                }
                if (this.bJa != null && context != null) {
                    this.iZf = this.bJa.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.iZg = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.bJa.getLevel_id()));
                }
                this.iYV = post.is_ntitle.intValue() == 1;
                this.iYO = post.sub_post_number.intValue();
                this.iZa = new i(post.tpoint_post);
                this.iYS = TbRichTextView.a(context, post.content, true);
                if (this.iYS != null) {
                    this.iYS.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.iYS.lx(this.iYL);
                    if (this.bJa != null) {
                        this.iYS.setAuthorId(this.bJa.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.iYY = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.qJ(this.iZt);
                            postData.a(subPostList, context);
                            this.iYP.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.iYU.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.iYW = new com.baidu.tbadk.data.c();
                    this.iYW.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.iYX = new com.baidu.tbadk.data.f();
                    this.iYX.a(post.lbs_info);
                }
                this.bJL = post.storecount.intValue();
                this.iYT.a(post.present);
                this.bJn.setUserMap(this.userMap);
                this.bJn.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.hVe = new SmallTailInfo();
                    this.hVe.id = post.signature.signature_id.intValue();
                    this.hVe.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.hVe.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.hVe.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.hVe.updateShowInfo();
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
                this.iZh = post.tpoint_post;
                if (post.agree != null) {
                    this.iZi = true;
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
                    this.iZi = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.bKE < 0) {
                    this.bKE = 0L;
                }
                this.iZo = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.bKP = new OriginalThreadInfo();
                    this.bKP.parser(post.origin_thread_info);
                } else {
                    this.bKP = null;
                }
                this.iZr = post.is_fold.intValue();
                this.hBH = post.fold_tip;
                this.iZv = post.is_top_agree_post.intValue() == 1;
                this.iZw = post.show_squared.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int hTd;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(this.hTd));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> iZF;
        private b iZG;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.iZF = new SoftReference<>(context);
            this.iZG = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.iZF != null) {
                if (this.iZG != null) {
                    this.iZG.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.iZF.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String el(Context context) {
        ArrayList<TbRichTextData> axz;
        if (this.iYS == null || (axz = this.iYS.axz()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = axz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.axH().toString());
            } else if (next.getType() == 17) {
                String str = next.axL().mGifInfo.mSharpText;
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

    public String cmB() {
        ArrayList<TbRichTextData> axz;
        String str;
        if (this.iYS == null || (axz = this.iYS.axz()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = axz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.axH().toString());
                } else if (next.getType() == 17) {
                    if (next.axL() != null && next.axL().mGifInfo != null && (str = next.axL().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cmC() {
        ArrayList<TbRichTextData> axz;
        if (this.iYS != null && (axz = this.iYS.axz()) != null) {
            Iterator<TbRichTextData> it = axz.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.axG().getWidth();
                    preLoadImageInfo.height = next.axG().getHeight();
                    preLoadImageInfo.imgUrl = next.axG().axU();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.axM().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.axM().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.axM().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cmD() {
        k clZ;
        PreLoadImageInfo cmC = cmC();
        if (cmC != null && !StringUtils.isNull(cmC.imgUrl)) {
            return cmC.imgUrl;
        }
        if (this.iZa != null && (clZ = this.iZa.clZ()) != null && !StringUtils.isNull(clZ.cme())) {
            return clZ.cme();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> axz;
        if (this.iYS == null || (axz = this.iYS.axz()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = axz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.axG().getWidth();
                preLoadImageInfo.height = next.axG().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.axG().axZ()) {
                    preLoadImageInfo.imgUrl = next.axG().axV();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.axG().axU();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.axL() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.axL().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.axL().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.axL();
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
        if (this.iYK == 52) {
            return iYG;
        }
        if (this.iYK == 1) {
            return bKc;
        }
        if (this.iYK == 36) {
            return iYD;
        }
        if (this.iYK == 40 || this.iYK == 50) {
            return bIw;
        }
        if (this.iYK == 41) {
            return iYE;
        }
        if (this.iYK == 53) {
            return iYH;
        }
        if (cmw() == 1) {
            return iYB;
        }
        return iYC;
    }

    public void setPostType(int i) {
        this.iYK = i;
    }

    public ao cmE() {
        return this.iYT;
    }

    public void a(ao aoVar) {
        this.iYT = aoVar;
    }

    public i cmF() {
        return this.iZa;
    }

    public com.baidu.tbadk.widget.richText.f axK() {
        if (this.iZe != null) {
            return this.iZe;
        }
        if (this.iYS != null && v.Z(this.iYS.axz()) > 0) {
            Iterator<TbRichTextData> it = this.iYS.axz().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.iZe = next.axK();
                    return this.iZe;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo axI() {
        if (this.cbi != null) {
            return this.cbi;
        }
        if (this.iYS != null && v.Z(this.iYS.axz()) > 0) {
            Iterator<TbRichTextData> it = this.iYS.axz().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.cbi = next.axI();
                    return this.cbi;
                }
            }
        }
        return null;
    }

    public String cmG() {
        return this.iZf;
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

    public boolean bmp() {
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

    public OriginalThreadInfo cmH() {
        return this.bKP;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.bKP = originalThreadInfo;
    }

    public int cmI() {
        return this.iZr;
    }

    public String bPT() {
        return this.hBH;
    }

    public boolean cmJ() {
        return this.iZw;
    }
}
