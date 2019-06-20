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
    private long bKF;
    private int bKH;
    private OriginalThreadInfo bKQ;
    private SkinInfo bKc;
    private String bKf;
    private String bimg_url;
    private TbRichTextVoiceInfo cbj;
    private String hAX;
    private String hBI;
    private SmallTailInfo hVf;
    private ArrayList<PostData> iYT;
    private boolean iZA;
    public am iZC;
    private com.baidu.tbadk.data.c iZa;
    private com.baidu.tbadk.data.f iZb;
    private i iZe;
    private bc iZf;
    public boolean iZh;
    private com.baidu.tbadk.widget.richText.f iZi;
    private String iZj;
    private String iZk;
    private TPointPost iZl;
    public int iZo;
    public AlaLiveInfoCoreData iZt;
    private boolean iZx;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId iYF = BdUniqueId.gen();
    public static final BdUniqueId iYG = BdUniqueId.gen();
    public static final BdUniqueId bKd = BdUniqueId.gen();
    public static final BdUniqueId iYH = BdUniqueId.gen();
    public static final BdUniqueId bIx = BdUniqueId.gen();
    public static final BdUniqueId iYI = BdUniqueId.gen();
    public static final BdUniqueId iYJ = BdUniqueId.gen();
    public static final BdUniqueId iYK = BdUniqueId.gen();
    public static final BdUniqueId iYL = BdUniqueId.gen();
    public static final BdUniqueId iYM = BdUniqueId.gen();
    public static boolean iYN = false;
    private int iYO = 0;
    private boolean iYU = false;
    private ArrayList<PostData> iYV = null;
    private TbRichText iYW = null;
    private boolean iYZ = false;
    private boolean iZc = false;
    private boolean iZd = false;
    public boolean iZg = false;
    public int bJB = 0;
    private boolean iZm = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean fwl = false;
    public boolean iZn = false;
    public boolean iZp = false;
    public boolean iZq = true;
    public boolean iZr = false;
    public boolean iZs = false;
    private boolean iZu = false;
    private int iZv = 0;
    private boolean iZw = true;
    public boolean iZy = false;
    public boolean iZz = false;
    public boolean iZB = false;
    private b iZD = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.iZC != null) {
                am aie = PostData.this.iZC.aie();
                aie.delete("obj_locate");
                aie.P("obj_locate", 7);
                TiebaStatic.log(aie);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int iYP = 0;
    private long time = 0;
    private String date = null;
    private MetaData bJb = new MetaData();
    private ArrayList<l> iYQ = new ArrayList<>();
    private ArrayList<l> iYR = new ArrayList<>();
    private int iYS = 0;
    private int bJM = 0;
    private PraiseData bJo = new PraiseData();
    private ao iYX = new ao();
    private c iYY = new c();
    private ArrayList<com.baidu.tbadk.data.c> bJZ = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.iYT = null;
        this.iZo = 0;
        this.iYT = new ArrayList<>();
        this.iZo = 0;
    }

    public void qK(boolean z) {
        this.iZx = z;
    }

    public boolean cmp() {
        return this.iZx;
    }

    public ArrayList<PostData> cmq() {
        return this.iYV;
    }

    public void cmr() {
        this.iYV.clear();
        this.iYV = null;
        this.iYU = false;
    }

    public void r(PostData postData) {
        if (postData != null) {
            if (this.iYV == null) {
                this.iYV = new ArrayList<>();
                if (v.Z(this.iYT) > 2) {
                    this.iYV.addAll(v.c(this.iYT, 0, 2));
                } else {
                    this.iYV.addAll(this.iYT);
                }
            }
            this.iYV.add(postData);
        }
    }

    public void s(PostData postData) {
        if (postData != null && this.iYT != null) {
            this.iYT.add(postData);
            cmv();
        }
    }

    public void DW(String str) {
        if (this.iYV != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.iYV.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.iYV.remove(next);
                    return;
                }
            }
        }
    }

    public void qL(boolean z) {
        this.iZw = z;
    }

    public boolean cms() {
        return this.iZw;
    }

    public void qM(boolean z) {
        this.iYU = z;
    }

    public boolean cmt() {
        return this.iYU;
    }

    public ArrayList<PostData> cmu() {
        return this.iYT;
    }

    public void cmv() {
        this.iYS++;
    }

    public void cmw() {
        this.iYS--;
    }

    public void Ax(int i) {
        this.iYS = i;
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

    public String bPG() {
        return this.hAX;
    }

    public int cmx() {
        return this.iYP;
    }

    public void Ay(int i) {
        this.iYP = i;
    }

    public boolean cmy() {
        return this.iZd;
    }

    public void qN(boolean z) {
        this.iZd = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ap.aC(j);
    }

    public MetaData adv() {
        return this.bJb;
    }

    public void a(MetaData metaData) {
        this.bJb = metaData;
    }

    public void a(PraiseData praiseData) {
        this.bJo = praiseData;
    }

    public TbRichText cmz() {
        return this.iYW;
    }

    public void c(TbRichText tbRichText) {
        this.iYW = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bWI() {
        return this.hVf;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.hVf = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cmA() {
        return this.iZb;
    }

    public SkinInfo adQ() {
        return this.bKc;
    }

    public void qO(boolean z) {
        this.iZu = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.iYW != null && this.iYW.axz() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.bJb != null && this.bJb.getIs_bawu() == 1) {
                    if (this.iZx) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.bJb.getBawu_type())) {
                        str = " 吧主";
                    } else if ("assist".equals(this.bJb.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.bJb.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.bJb.getBawu_type())) {
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
                                            PostData.this.iYW.isChanged = true;
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
            if (!StringUtils.isNull(this.bJb.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.bJb.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.bJb == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.bJb.getName_show() + str + "：");
                str2 = this.bJb.getUserName();
                str3 = this.bJb.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.bJb.getSealPrefix())) {
                Bitmap id = al.id(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(id);
                if (id != null) {
                    bitmapDrawable.setBounds(0, 0, id.getWidth(), id.getHeight());
                }
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.bJb.getSealPrefix().length() + 1;
                spannableString.setSpan(kVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.iZD), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.bJb != null && this.bJb.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.c aj = aj(z, this.bJb != null && this.bJb.getIs_bawu() == 1);
                if (aj != null) {
                    if (this.bJb != null) {
                        int i3 = 0;
                        if (this.bJb.getName_show() != null) {
                            i3 = this.bJb.getName_show().length();
                        }
                        spannableString.setSpan(aj, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(aj, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> axz = this.iYW.axz();
            if (axz != null && axz.size() > 0) {
                TbRichTextData tbRichTextData2 = axz.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.axH() != null) {
                    if (this.iZu) {
                        int indexOf = tbRichTextData2.axH().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.axH().delete(0, indexOf + 1);
                        }
                        this.iZu = false;
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
            this.iZy = true;
        }
    }

    private com.baidu.tbadk.core.view.c aj(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds5), this.iZx ? R.color.cp_link_tip_a_alpha50 : R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds26), this.iZx ? R.color.cp_link_tip_a : R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds40));
        if (this.iZx) {
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

    public int cmB() {
        return this.iYS;
    }

    public void ej(Context context) {
        int type;
        int i;
        int i2;
        if (this.iYQ != null) {
            int i3 = -1;
            int size = this.iYR.size();
            if (size > 0) {
                try {
                    i3 = this.iYR.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.iYQ.size()) {
                l lVar = this.iYQ.get(i4);
                if (l.cv(i5, lVar.getType())) {
                    this.iYR.get(size - 1).b(lVar.ei(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.iYR.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.ei(context));
                        this.iYR.add(lVar2);
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
            if (this.iYW != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.iYW.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.iYR == null || this.iYR.size() == 0) {
                ej(context);
            }
            ArrayList<l> arrayList = this.iYR;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cmi() != null) {
                            sb.append((CharSequence) next.cmi());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String pQ = TbFaceManager.aso().pQ(next.getText());
                        if (pQ != null) {
                            sb.append("[");
                            sb.append(pQ);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ap.isEmpty(next.cmh())) {
                        sb.append("[").append(next.cmh()).append("]");
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
                this.iYP = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = ap.aC(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.iZc = subPostList.is_giftpost.intValue() == 1;
                this.agree = subPostList.agree;
                if (this.agree != null) {
                    this.bKH = this.agree.agree_type.intValue();
                    this.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeNum = this.agree.agree_num.longValue() > 0 ? this.agree.agree_num.longValue() : 0L;
                    this.bKF = this.agree.disagree_num.longValue() > 0 ? this.agree.disagree_num.longValue() : 0L;
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
                    this.bJb = metaData;
                }
                if ((this.bJb.getUserId() == null || this.bJb.getUserId().length() <= 0 || this.bJb.getUserId().equals("0")) && metaData2 != null) {
                    this.bJb = metaData2;
                }
                this.iYW = TbRichTextView.a(context, subPostList.content, z);
                if (this.iYW != null) {
                    this.iYW.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.iYP = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = ap.aC(this.time);
                this.hAX = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bJb = metaData;
                }
                this.fwl = post.need_log.intValue() == 1;
                this.iZn = post.img_num_abtest.intValue() == 1;
                this.iZf = new bc();
                this.iZf.parserProtobuf(post.from_forum);
                if (this.bJb.getUserId() == null || this.bJb.getUserId().length() <= 0 || this.bJb.getUserId().equals("0")) {
                    this.bJb.parserProtobuf(post.author);
                }
                if (this.bJb != null && context != null) {
                    this.iZj = this.bJb.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.iZk = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.bJb.getLevel_id()));
                }
                this.iYZ = post.is_ntitle.intValue() == 1;
                this.iYS = post.sub_post_number.intValue();
                this.iZe = new i(post.tpoint_post);
                this.iYW = TbRichTextView.a(context, post.content, true);
                if (this.iYW != null) {
                    this.iYW.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.iYW.lx(this.iYP);
                    if (this.bJb != null) {
                        this.iYW.setAuthorId(this.bJb.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.iZc = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.qK(this.iZx);
                            postData.a(subPostList, context);
                            this.iYT.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.iYY.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.iZa = new com.baidu.tbadk.data.c();
                    this.iZa.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.iZb = new com.baidu.tbadk.data.f();
                    this.iZb.a(post.lbs_info);
                }
                this.bJM = post.storecount.intValue();
                this.iYX.a(post.present);
                this.bJo.setUserMap(this.userMap);
                this.bJo.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.hVf = new SmallTailInfo();
                    this.hVf.id = post.signature.signature_id.intValue();
                    this.hVf.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.hVf.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.hVf.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.hVf.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.bJZ.add(cVar);
                    }
                }
                this.bKc = post.skin_info;
                this.bKf = post.lego_card;
                this.iZl = post.tpoint_post;
                if (post.agree != null) {
                    this.iZm = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                    if (post.agree.disagree_num.longValue() >= 0) {
                        this.bKF = post.agree.disagree_num.longValue();
                    } else {
                        this.bKF = 0L;
                    }
                    this.bKH = post.agree.agree_type.intValue();
                    this.agreeData.postId = this.id;
                    this.agreeData.agreeType = post.agree.agree_type == null ? 0 : post.agree.agree_type.intValue();
                    this.agreeData.hasAgree = post.agree.has_agree.intValue() == 1;
                    this.agreeData.agreeNum = this.agreeNum;
                    this.agreeData.disAgreeNum = this.bKF;
                    this.agreeData.diffAgreeNum = post.agree.diff_agree_num == null ? 0L : post.agree.diff_agree_num.longValue();
                } else {
                    this.iZm = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.bKF < 0) {
                    this.bKF = 0L;
                }
                this.iZs = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.bKQ = new OriginalThreadInfo();
                    this.bKQ.parser(post.origin_thread_info);
                } else {
                    this.bKQ = null;
                }
                this.iZv = post.is_fold.intValue();
                this.hBI = post.fold_tip;
                this.iZz = post.is_top_agree_post.intValue() == 1;
                this.iZA = post.show_squared.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int hTe;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(this.hTe));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> iZJ;
        private b iZK;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.iZJ = new SoftReference<>(context);
            this.iZK = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.iZJ != null) {
                if (this.iZK != null) {
                    this.iZK.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.iZJ.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String el(Context context) {
        ArrayList<TbRichTextData> axz;
        if (this.iYW == null || (axz = this.iYW.axz()) == null) {
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

    public String cmC() {
        ArrayList<TbRichTextData> axz;
        String str;
        if (this.iYW == null || (axz = this.iYW.axz()) == null) {
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

    public PreLoadImageInfo cmD() {
        ArrayList<TbRichTextData> axz;
        if (this.iYW != null && (axz = this.iYW.axz()) != null) {
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

    public String cmE() {
        k cma;
        PreLoadImageInfo cmD = cmD();
        if (cmD != null && !StringUtils.isNull(cmD.imgUrl)) {
            return cmD.imgUrl;
        }
        if (this.iZe != null && (cma = this.iZe.cma()) != null && !StringUtils.isNull(cma.cmf())) {
            return cma.cmf();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> axz;
        if (this.iYW == null || (axz = this.iYW.axz()) == null) {
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
        if (this.bJb == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.bJb.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.iYO == 52) {
            return iYK;
        }
        if (this.iYO == 1) {
            return bKd;
        }
        if (this.iYO == 36) {
            return iYH;
        }
        if (this.iYO == 40 || this.iYO == 50) {
            return bIx;
        }
        if (this.iYO == 41) {
            return iYI;
        }
        if (this.iYO == 53) {
            return iYL;
        }
        if (cmx() == 1) {
            return iYF;
        }
        return iYG;
    }

    public void setPostType(int i) {
        this.iYO = i;
    }

    public ao cmF() {
        return this.iYX;
    }

    public void a(ao aoVar) {
        this.iYX = aoVar;
    }

    public i cmG() {
        return this.iZe;
    }

    public com.baidu.tbadk.widget.richText.f axK() {
        if (this.iZi != null) {
            return this.iZi;
        }
        if (this.iYW != null && v.Z(this.iYW.axz()) > 0) {
            Iterator<TbRichTextData> it = this.iYW.axz().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.iZi = next.axK();
                    return this.iZi;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo axI() {
        if (this.cbj != null) {
            return this.cbj;
        }
        if (this.iYW != null && v.Z(this.iYW.axz()) > 0) {
            Iterator<TbRichTextData> it = this.iYW.axz().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.cbj = next.axI();
                    return this.cbj;
                }
            }
        }
        return null;
    }

    public String cmH() {
        return this.iZj;
    }

    public String aex() {
        return this.bKf;
    }

    public void aez() {
        if (this.bJB == 0) {
            this.bJB = 1;
        }
    }

    public long aeO() {
        return this.agreeNum;
    }

    public long aeP() {
        return this.bKF;
    }

    public void ar(long j) {
        this.agreeNum = j;
    }

    public boolean bmp() {
        return this.hasAgree;
    }

    public void hl(int i) {
        this.bKH = i;
    }

    public void qP(boolean z) {
        this.hasAgree = z;
    }

    public int aeR() {
        return this.bKH;
    }

    public void as(long j) {
        this.bKF = j;
    }

    public AgreeData afl() {
        return this.agreeData;
    }

    public OriginalThreadInfo cmI() {
        return this.bKQ;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.bKQ = originalThreadInfo;
    }

    public int cmJ() {
        return this.iZv;
    }

    public String bPU() {
        return this.hBI;
    }

    public boolean cmK() {
        return this.iZA;
    }
}
