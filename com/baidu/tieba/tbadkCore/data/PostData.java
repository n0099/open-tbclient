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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
    private long bLK;
    private int bLM;
    private OriginalThreadInfo bLV;
    private SkinInfo bLh;
    private String bLk;
    private String bimg_url;
    private TbRichTextVoiceInfo cct;
    private String hIO;
    private String hId;
    private SmallTailInfo icp;
    private i jgC;
    private bd jgD;
    public boolean jgF;
    private com.baidu.tbadk.widget.richText.f jgG;
    private String jgH;
    private String jgI;
    private TPointPost jgJ;
    public int jgM;
    public AlaLiveInfoCoreData jgR;
    private boolean jgV;
    private boolean jgY;
    private ArrayList<PostData> jgr;
    private com.baidu.tbadk.data.c jgy;
    private com.baidu.tbadk.data.f jgz;
    public an jha;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId jgd = BdUniqueId.gen();
    public static final BdUniqueId jge = BdUniqueId.gen();
    public static final BdUniqueId bLi = BdUniqueId.gen();
    public static final BdUniqueId jgf = BdUniqueId.gen();
    public static final BdUniqueId bJC = BdUniqueId.gen();
    public static final BdUniqueId jgg = BdUniqueId.gen();
    public static final BdUniqueId jgh = BdUniqueId.gen();
    public static final BdUniqueId jgi = BdUniqueId.gen();
    public static final BdUniqueId jgj = BdUniqueId.gen();
    public static final BdUniqueId jgk = BdUniqueId.gen();
    public static boolean jgl = false;
    private int jgm = 0;
    private boolean jgs = false;
    private ArrayList<PostData> jgt = null;
    private TbRichText jgu = null;
    private boolean jgx = false;
    private boolean jgA = false;
    private boolean jgB = false;
    public boolean jgE = false;
    public int bKG = 0;
    private boolean jgK = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean fBV = false;
    public boolean jgL = false;
    public boolean jgN = false;
    public boolean jgO = true;
    public boolean jgP = false;
    public boolean jgQ = false;
    private boolean jgS = false;
    private int jgT = 0;
    private boolean jgU = true;
    public boolean jgW = false;
    public boolean jgX = false;
    public boolean jgZ = false;
    private b jhb = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.jha != null) {
                an ajj = PostData.this.jha.ajj();
                ajj.nV("obj_locate");
                ajj.P("obj_locate", 7);
                TiebaStatic.log(ajj);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int jgn = 0;
    private long time = 0;
    private String date = null;
    private MetaData bKg = new MetaData();
    private ArrayList<l> jgo = new ArrayList<>();
    private ArrayList<l> jgp = new ArrayList<>();
    private int jgq = 0;
    private int bKR = 0;
    private PraiseData bKt = new PraiseData();
    private ao jgv = new ao();
    private c jgw = new c();
    private ArrayList<com.baidu.tbadk.data.c> bLe = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.jgr = null;
        this.jgM = 0;
        this.jgr = new ArrayList<>();
        this.jgM = 0;
    }

    public void ra(boolean z) {
        this.jgV = z;
    }

    public boolean cpD() {
        return this.jgV;
    }

    public ArrayList<PostData> cpE() {
        return this.jgt;
    }

    public void cpF() {
        this.jgt.clear();
        this.jgt = null;
        this.jgs = false;
    }

    public void r(PostData postData) {
        if (postData != null) {
            if (this.jgt == null) {
                this.jgt = new ArrayList<>();
                if (v.Z(this.jgr) > 2) {
                    this.jgt.addAll(v.c(this.jgr, 0, 2));
                } else {
                    this.jgt.addAll(this.jgr);
                }
            }
            this.jgt.add(postData);
        }
    }

    public void s(PostData postData) {
        if (postData != null && this.jgr != null) {
            this.jgr.add(postData);
            cpJ();
        }
    }

    public void EK(String str) {
        if (this.jgt != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.jgt.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.jgt.remove(next);
                    return;
                }
            }
        }
    }

    public void rb(boolean z) {
        this.jgU = z;
    }

    public boolean cpG() {
        return this.jgU;
    }

    public void rc(boolean z) {
        this.jgs = z;
    }

    public boolean cpH() {
        return this.jgs;
    }

    public ArrayList<PostData> cpI() {
        return this.jgr;
    }

    public void cpJ() {
        this.jgq++;
    }

    public void cpK() {
        this.jgq--;
    }

    public void Bf(int i) {
        this.jgq = i;
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

    public String bSF() {
        return this.hId;
    }

    public int cpL() {
        return this.jgn;
    }

    public void Bg(int i) {
        this.jgn = i;
    }

    public boolean cpM() {
        return this.jgB;
    }

    public void rd(boolean z) {
        this.jgB = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = aq.aD(j);
    }

    public MetaData aey() {
        return this.bKg;
    }

    public void a(MetaData metaData) {
        this.bKg = metaData;
    }

    public void a(PraiseData praiseData) {
        this.bKt = praiseData;
    }

    public TbRichText cpN() {
        return this.jgu;
    }

    public void c(TbRichText tbRichText) {
        this.jgu = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bZO() {
        return this.icp;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.icp = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cpO() {
        return this.jgz;
    }

    public SkinInfo aeT() {
        return this.bLh;
    }

    public void re(boolean z) {
        this.jgS = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.jgu != null && this.jgu.ayN() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.bKg != null && this.bKg.getIs_bawu() == 1) {
                    if (this.jgV) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.bKg.getBawu_type())) {
                        str = " 吧主";
                    } else if ("assist".equals(this.bKg.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.bKg.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.bKg.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = aey().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.iE().b(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.iE().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.nL()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.jgu.isChanged = true;
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
            if (!StringUtils.isNull(this.bKg.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.bKg.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.bKg == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.bKg.getName_show() + str + "：");
                str2 = this.bKg.getUserName();
                str3 = this.bKg.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.bKg.getSealPrefix())) {
                Bitmap ij = am.ij(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(ij);
                if (ij != null) {
                    bitmapDrawable.setBounds(0, 0, ij.getWidth(), ij.getHeight());
                }
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.bKg.getSealPrefix().length() + 1;
                spannableString.setSpan(kVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.jhb), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.bKg != null && this.bKg.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.c am = am(z, this.bKg != null && this.bKg.getIs_bawu() == 1);
                if (am != null) {
                    if (this.bKg != null) {
                        int i3 = 0;
                        if (this.bKg.getName_show() != null) {
                            i3 = this.bKg.getName_show().length();
                        }
                        spannableString.setSpan(am, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(am, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> ayN = this.jgu.ayN();
            if (ayN != null && ayN.size() > 0) {
                TbRichTextData tbRichTextData2 = ayN.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.ayV() != null) {
                    if (this.jgS) {
                        int indexOf = tbRichTextData2.ayV().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.ayV().delete(0, indexOf + 1);
                        }
                        this.jgS = false;
                    }
                    tbRichTextData2.lF(sb.length());
                    tbRichTextData2.ayV().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= ayN.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (ayN.get(i5) == null || ayN.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo ayW = ayN.get(i5).ayW();
                            ayN.remove(i5);
                            tbRichTextVoiceInfo = ayW;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.lF(sb.length());
                    tbRichTextData.k(spannableString);
                    ayN.add(0, tbRichTextData);
                }
            }
            this.jgW = true;
        }
    }

    private com.baidu.tbadk.core.view.c am(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds5), this.jgV ? R.color.cp_link_tip_a_alpha50 : R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds26), this.jgV ? R.color.cp_link_tip_a : R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds40));
        if (this.jgV) {
            cVar.el(false);
            return cVar;
        }
        cVar.el(true);
        return cVar;
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap nK;
        if (aVar == null || (nK = aVar.nK()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(nK);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36));
        return bitmapDrawable;
    }

    public int cpP() {
        return this.jgq;
    }

    public void el(Context context) {
        int type;
        int i;
        int i2;
        if (this.jgo != null) {
            int i3 = -1;
            int size = this.jgp.size();
            if (size > 0) {
                try {
                    i3 = this.jgp.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.jgo.size()) {
                l lVar = this.jgo.get(i4);
                if (l.cA(i5, lVar.getType())) {
                    this.jgp.get(size - 1).b(lVar.ek(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.jgp.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.ek(context));
                        this.jgp.add(lVar2);
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

    public void em(Context context) {
        try {
            if (this.jgu != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.jgu.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.jgp == null || this.jgp.size() == 0) {
                el(context);
            }
            ArrayList<l> arrayList = this.jgp;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cpw() != null) {
                            sb.append((CharSequence) next.cpw());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String qh = TbFaceManager.atx().qh(next.getText());
                        if (qh != null) {
                            sb.append("[");
                            sb.append(qh);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aq.isEmpty(next.cpv())) {
                        sb.append("[").append(next.cpv()).append("]");
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
                this.jgn = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = aq.aD(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.jgA = subPostList.is_giftpost.intValue() == 1;
                this.agree = subPostList.agree;
                if (this.agree != null) {
                    this.bLM = this.agree.agree_type.intValue();
                    this.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeNum = this.agree.agree_num.longValue() > 0 ? this.agree.agree_num.longValue() : 0L;
                    this.bLK = this.agree.disagree_num.longValue() > 0 ? this.agree.disagree_num.longValue() : 0L;
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
                    this.bKg = metaData;
                }
                if ((this.bKg.getUserId() == null || this.bKg.getUserId().length() <= 0 || this.bKg.getUserId().equals("0")) && metaData2 != null) {
                    this.bKg = metaData2;
                }
                this.jgu = TbRichTextView.a(context, subPostList.content, z);
                if (this.jgu != null) {
                    this.jgu.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.jgn = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = aq.aD(this.time);
                this.hId = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bKg = metaData;
                }
                this.fBV = post.need_log.intValue() == 1;
                this.jgL = post.img_num_abtest.intValue() == 1;
                this.jgD = new bd();
                this.jgD.parserProtobuf(post.from_forum);
                if (this.bKg.getUserId() == null || this.bKg.getUserId().length() <= 0 || this.bKg.getUserId().equals("0")) {
                    this.bKg.parserProtobuf(post.author);
                }
                if (this.bKg != null && context != null) {
                    this.jgH = this.bKg.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.jgI = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.bKg.getLevel_id()));
                }
                this.jgx = post.is_ntitle.intValue() == 1;
                this.jgq = post.sub_post_number.intValue();
                this.jgC = new i(post.tpoint_post);
                this.jgu = TbRichTextView.a(context, post.content, true);
                if (this.jgu != null) {
                    this.jgu.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.jgu.lE(this.jgn);
                    if (this.bKg != null) {
                        this.jgu.setAuthorId(this.bKg.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.jgA = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.ra(this.jgV);
                            postData.a(subPostList, context);
                            this.jgr.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.jgw.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.jgy = new com.baidu.tbadk.data.c();
                    this.jgy.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.jgz = new com.baidu.tbadk.data.f();
                    this.jgz.a(post.lbs_info);
                }
                this.bKR = post.storecount.intValue();
                this.jgv.a(post.present);
                this.bKt.setUserMap(this.userMap);
                this.bKt.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.icp = new SmallTailInfo();
                    this.icp.id = post.signature.signature_id.intValue();
                    this.icp.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.icp.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.icp.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.icp.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.bLe.add(cVar);
                    }
                }
                this.bLh = post.skin_info;
                this.bLk = post.lego_card;
                this.jgJ = post.tpoint_post;
                if (post.agree != null) {
                    this.jgK = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                    if (post.agree.disagree_num.longValue() >= 0) {
                        this.bLK = post.agree.disagree_num.longValue();
                    } else {
                        this.bLK = 0L;
                    }
                    this.bLM = post.agree.agree_type.intValue();
                    this.agreeData.postId = this.id;
                    this.agreeData.agreeType = post.agree.agree_type == null ? 0 : post.agree.agree_type.intValue();
                    this.agreeData.hasAgree = post.agree.has_agree.intValue() == 1;
                    this.agreeData.agreeNum = this.agreeNum;
                    this.agreeData.disAgreeNum = this.bLK;
                    this.agreeData.diffAgreeNum = post.agree.diff_agree_num == null ? 0L : post.agree.diff_agree_num.longValue();
                } else {
                    this.jgK = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.bLK < 0) {
                    this.bLK = 0L;
                }
                this.jgQ = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.bLV = new OriginalThreadInfo();
                    this.bLV.parser(post.origin_thread_info);
                } else {
                    this.bLV = null;
                }
                this.jgT = post.is_fold.intValue();
                this.hIO = post.fold_tip;
                this.jgX = post.is_top_agree_post.intValue() == 1;
                this.jgY = post.show_squared.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int iao;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(this.iao));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> jhh;
        private b jhi;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.jhh = new SoftReference<>(context);
            this.jhi = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.jhh != null) {
                if (this.jhi != null) {
                    this.jhi.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.jhh.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String en(Context context) {
        ArrayList<TbRichTextData> ayN;
        if (this.jgu == null || (ayN = this.jgu.ayN()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = ayN.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.ayV().toString());
            } else if (next.getType() == 17) {
                String str = next.ayZ().mGifInfo.mSharpText;
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

    public String cpQ() {
        ArrayList<TbRichTextData> ayN;
        String str;
        if (this.jgu == null || (ayN = this.jgu.ayN()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = ayN.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.ayV().toString());
                } else if (next.getType() == 17) {
                    if (next.ayZ() != null && next.ayZ().mGifInfo != null && (str = next.ayZ().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cpR() {
        ArrayList<TbRichTextData> ayN;
        if (this.jgu != null && (ayN = this.jgu.ayN()) != null) {
            Iterator<TbRichTextData> it = ayN.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.ayU().getWidth();
                    preLoadImageInfo.height = next.ayU().getHeight();
                    preLoadImageInfo.imgUrl = next.ayU().azi();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.aza().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.aza().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.aza().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cpS() {
        k cpo;
        PreLoadImageInfo cpR = cpR();
        if (cpR != null && !StringUtils.isNull(cpR.imgUrl)) {
            return cpR.imgUrl;
        }
        if (this.jgC != null && (cpo = this.jgC.cpo()) != null && !StringUtils.isNull(cpo.cpt())) {
            return cpo.cpt();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> ayN;
        if (this.jgu == null || (ayN = this.jgu.ayN()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = ayN.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.ayU().getWidth();
                preLoadImageInfo.height = next.ayU().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.ayU().azn()) {
                    preLoadImageInfo.imgUrl = next.ayU().azj();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.ayU().azi();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.ayZ() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.ayZ().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.ayZ().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.ayZ();
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
        if (this.bKg == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.bKg.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.jgm == 52) {
            return jgi;
        }
        if (this.jgm == 1) {
            return bLi;
        }
        if (this.jgm == 36) {
            return jgf;
        }
        if (this.jgm == 40 || this.jgm == 50) {
            return bJC;
        }
        if (this.jgm == 41) {
            return jgg;
        }
        if (this.jgm == 53) {
            return jgj;
        }
        if (cpL() == 1) {
            return jgd;
        }
        return jge;
    }

    public void setPostType(int i) {
        this.jgm = i;
    }

    public ao cpT() {
        return this.jgv;
    }

    public void a(ao aoVar) {
        this.jgv = aoVar;
    }

    public i cpU() {
        return this.jgC;
    }

    public com.baidu.tbadk.widget.richText.f ayY() {
        if (this.jgG != null) {
            return this.jgG;
        }
        if (this.jgu != null && v.Z(this.jgu.ayN()) > 0) {
            Iterator<TbRichTextData> it = this.jgu.ayN().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.jgG = next.ayY();
                    return this.jgG;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo ayW() {
        if (this.cct != null) {
            return this.cct;
        }
        if (this.jgu != null && v.Z(this.jgu.ayN()) > 0) {
            Iterator<TbRichTextData> it = this.jgu.ayN().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.cct = next.ayW();
                    return this.cct;
                }
            }
        }
        return null;
    }

    public String cpV() {
        return this.jgH;
    }

    public String afA() {
        return this.bLk;
    }

    public void afC() {
        if (this.bKG == 0) {
            this.bKG = 1;
        }
    }

    public long afR() {
        return this.agreeNum;
    }

    public long afS() {
        return this.bLK;
    }

    public void as(long j) {
        this.agreeNum = j;
    }

    public boolean boD() {
        return this.hasAgree;
    }

    public void hr(int i) {
        this.bLM = i;
    }

    public void rf(boolean z) {
        this.hasAgree = z;
    }

    public int afU() {
        return this.bLM;
    }

    public void at(long j) {
        this.bLK = j;
    }

    public AgreeData ago() {
        return this.agreeData;
    }

    public OriginalThreadInfo cpW() {
        return this.bLV;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.bLV = originalThreadInfo;
    }

    public int cpX() {
        return this.jgT;
    }

    public String bST() {
        return this.hIO;
    }

    public boolean cpY() {
        return this.jgY;
    }
}
