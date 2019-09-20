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
    private SkinInfo bLF;
    private String bLI;
    private long bMi;
    private int bMk;
    private OriginalThreadInfo bMt;
    private String bimg_url;
    private TbRichTextVoiceInfo cdm;
    private String hJZ;
    private String hKK;
    private SmallTailInfo ier;
    private ArrayList<PostData> jiN;
    private com.baidu.tbadk.data.c jiU;
    private com.baidu.tbadk.data.f jiV;
    private i jiY;
    private bd jiZ;
    public boolean jjb;
    private com.baidu.tbadk.widget.richText.f jjc;
    private String jjd;
    private String jje;
    private TPointPost jjf;
    public int jji;
    public AlaLiveInfoCoreData jjn;
    private boolean jjr;
    private boolean jju;
    public an jjw;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId jiz = BdUniqueId.gen();
    public static final BdUniqueId jiA = BdUniqueId.gen();
    public static final BdUniqueId bLG = BdUniqueId.gen();
    public static final BdUniqueId jiB = BdUniqueId.gen();
    public static final BdUniqueId bKa = BdUniqueId.gen();
    public static final BdUniqueId jiC = BdUniqueId.gen();
    public static final BdUniqueId jiD = BdUniqueId.gen();
    public static final BdUniqueId jiE = BdUniqueId.gen();
    public static final BdUniqueId jiF = BdUniqueId.gen();
    public static final BdUniqueId jiG = BdUniqueId.gen();
    public static boolean jiH = false;
    private int jiI = 0;
    private boolean jiO = false;
    private ArrayList<PostData> jiP = null;
    private TbRichText jiQ = null;
    private boolean jiT = false;
    private boolean jiW = false;
    private boolean jiX = false;
    public boolean jja = false;
    public int bLe = 0;
    private boolean jjg = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean fDI = false;
    public boolean jjh = false;
    public boolean jjj = false;
    public boolean jjk = true;
    public boolean jjl = false;
    public boolean jjm = false;
    private boolean jjo = false;
    private int jjp = 0;
    private boolean jjq = true;
    public boolean jjs = false;
    public boolean jjt = false;
    public boolean jjv = false;
    private b jjx = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.jjw != null) {
                an ajp = PostData.this.jjw.ajp();
                ajp.nX("obj_locate");
                ajp.P("obj_locate", 7);
                TiebaStatic.log(ajp);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int jiJ = 0;
    private long time = 0;
    private String date = null;
    private MetaData bKE = new MetaData();
    private ArrayList<l> jiK = new ArrayList<>();
    private ArrayList<l> jiL = new ArrayList<>();
    private int jiM = 0;
    private int bLp = 0;
    private PraiseData bKR = new PraiseData();
    private ao jiR = new ao();
    private c jiS = new c();
    private ArrayList<com.baidu.tbadk.data.c> bLC = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.jiN = null;
        this.jji = 0;
        this.jiN = new ArrayList<>();
        this.jji = 0;
    }

    public void rd(boolean z) {
        this.jjr = z;
    }

    public boolean cqr() {
        return this.jjr;
    }

    public ArrayList<PostData> cqs() {
        return this.jiP;
    }

    public void cqt() {
        this.jiP.clear();
        this.jiP = null;
        this.jiO = false;
    }

    public void r(PostData postData) {
        if (postData != null) {
            if (this.jiP == null) {
                this.jiP = new ArrayList<>();
                if (v.Z(this.jiN) > 2) {
                    this.jiP.addAll(v.c(this.jiN, 0, 2));
                } else {
                    this.jiP.addAll(this.jiN);
                }
            }
            this.jiP.add(postData);
        }
    }

    public void s(PostData postData) {
        if (postData != null && this.jiN != null) {
            this.jiN.add(postData);
            cqx();
        }
    }

    public void Fk(String str) {
        if (this.jiP != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.jiP.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.jiP.remove(next);
                    return;
                }
            }
        }
    }

    public void re(boolean z) {
        this.jjq = z;
    }

    public boolean cqu() {
        return this.jjq;
    }

    public void rf(boolean z) {
        this.jiO = z;
    }

    public boolean cqv() {
        return this.jiO;
    }

    public ArrayList<PostData> cqw() {
        return this.jiN;
    }

    public void cqx() {
        this.jiM++;
    }

    public void cqy() {
        this.jiM--;
    }

    public void Bj(int i) {
        this.jiM = i;
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

    public String bTs() {
        return this.hJZ;
    }

    public int cqz() {
        return this.jiJ;
    }

    public void Bk(int i) {
        this.jiJ = i;
    }

    public boolean cqA() {
        return this.jiX;
    }

    public void rg(boolean z) {
        this.jiX = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = aq.aD(j);
    }

    public MetaData aeC() {
        return this.bKE;
    }

    public void a(MetaData metaData) {
        this.bKE = metaData;
    }

    public void a(PraiseData praiseData) {
        this.bKR = praiseData;
    }

    public TbRichText cqB() {
        return this.jiQ;
    }

    public void c(TbRichText tbRichText) {
        this.jiQ = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo caC() {
        return this.ier;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.ier = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cqC() {
        return this.jiV;
    }

    public SkinInfo aeX() {
        return this.bLF;
    }

    public void rh(boolean z) {
        this.jjo = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.jiQ != null && this.jiQ.ayZ() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.bKE != null && this.bKE.getIs_bawu() == 1) {
                    if (this.jjr) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.bKE.getBawu_type())) {
                        str = " 吧主";
                    } else if ("assist".equals(this.bKE.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.bKE.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.bKE.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = aeC().getTShowInfoNew();
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
                                            PostData.this.jiQ.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.f(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.bKE.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.bKE.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.bKE == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.bKE.getName_show() + str + "：");
                str2 = this.bKE.getUserName();
                str3 = this.bKE.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.bKE.getSealPrefix())) {
                Bitmap ij = am.ij(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(ij);
                if (ij != null) {
                    bitmapDrawable.setBounds(0, 0, ij.getWidth(), ij.getHeight());
                }
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.bKE.getSealPrefix().length() + 1;
                spannableString.setSpan(kVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.jjx), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.bKE != null && this.bKE.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.c ak = ak(z, this.bKE != null && this.bKE.getIs_bawu() == 1);
                if (ak != null) {
                    if (this.bKE != null) {
                        int i3 = 0;
                        if (this.bKE.getName_show() != null) {
                            i3 = this.bKE.getName_show().length();
                        }
                        spannableString.setSpan(ak, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(ak, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> ayZ = this.jiQ.ayZ();
            if (ayZ != null && ayZ.size() > 0) {
                TbRichTextData tbRichTextData2 = ayZ.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.azh() != null) {
                    if (this.jjo) {
                        int indexOf = tbRichTextData2.azh().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.azh().delete(0, indexOf + 1);
                        }
                        this.jjo = false;
                    }
                    tbRichTextData2.lJ(sb.length());
                    tbRichTextData2.azh().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= ayZ.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (ayZ.get(i5) == null || ayZ.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo azi = ayZ.get(i5).azi();
                            ayZ.remove(i5);
                            tbRichTextVoiceInfo = azi;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.lJ(sb.length());
                    tbRichTextData.k(spannableString);
                    ayZ.add(0, tbRichTextData);
                }
            }
            this.jjs = true;
        }
    }

    private com.baidu.tbadk.core.view.c ak(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds5), this.jjr ? R.color.cp_link_tip_a_alpha50 : R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds26), this.jjr ? R.color.cp_link_tip_a : R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds40));
        if (this.jjr) {
            cVar.eo(false);
            return cVar;
        }
        cVar.eo(true);
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

    public int cqD() {
        return this.jiM;
    }

    public void em(Context context) {
        int type;
        int i;
        int i2;
        if (this.jiK != null) {
            int i3 = -1;
            int size = this.jiL.size();
            if (size > 0) {
                try {
                    i3 = this.jiL.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.jiK.size()) {
                l lVar = this.jiK.get(i4);
                if (l.cz(i5, lVar.getType())) {
                    this.jiL.get(size - 1).b(lVar.el(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.jiL.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.el(context));
                        this.jiL.add(lVar2);
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

    public void en(Context context) {
        try {
            if (this.jiQ != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.jiQ.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.jiL == null || this.jiL.size() == 0) {
                em(context);
            }
            ArrayList<l> arrayList = this.jiL;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cqk() != null) {
                            sb.append((CharSequence) next.cqk());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String qs = TbFaceManager.atJ().qs(next.getText());
                        if (qs != null) {
                            sb.append("[");
                            sb.append(qs);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aq.isEmpty(next.cqj())) {
                        sb.append("[").append(next.cqj()).append("]");
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
                this.jiJ = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = aq.aD(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.jiW = subPostList.is_giftpost.intValue() == 1;
                this.agree = subPostList.agree;
                if (this.agree != null) {
                    this.bMk = this.agree.agree_type.intValue();
                    this.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeNum = this.agree.agree_num.longValue() > 0 ? this.agree.agree_num.longValue() : 0L;
                    this.bMi = this.agree.disagree_num.longValue() > 0 ? this.agree.disagree_num.longValue() : 0L;
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
                    this.bKE = metaData;
                }
                if ((this.bKE.getUserId() == null || this.bKE.getUserId().length() <= 0 || this.bKE.getUserId().equals("0")) && metaData2 != null) {
                    this.bKE = metaData2;
                }
                this.jiQ = TbRichTextView.a(context, subPostList.content, z);
                if (this.jiQ != null) {
                    this.jiQ.setPostId(com.baidu.adp.lib.g.b.e(this.id, -1L));
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
                this.jiJ = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = aq.aD(this.time);
                this.hJZ = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bKE = metaData;
                }
                this.fDI = post.need_log.intValue() == 1;
                this.jjh = post.img_num_abtest.intValue() == 1;
                this.jiZ = new bd();
                this.jiZ.parserProtobuf(post.from_forum);
                if (this.bKE.getUserId() == null || this.bKE.getUserId().length() <= 0 || this.bKE.getUserId().equals("0")) {
                    this.bKE.parserProtobuf(post.author);
                }
                if (this.bKE != null && context != null) {
                    this.jjd = this.bKE.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.jje = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.bKE.getLevel_id()));
                }
                this.jiT = post.is_ntitle.intValue() == 1;
                this.jiM = post.sub_post_number.intValue();
                this.jiY = new i(post.tpoint_post);
                this.jiQ = TbRichTextView.a(context, post.content, true);
                if (this.jiQ != null) {
                    this.jiQ.setPostId(com.baidu.adp.lib.g.b.e(this.id, -1L));
                    this.jiQ.lI(this.jiJ);
                    if (this.bKE != null) {
                        this.jiQ.setAuthorId(this.bKE.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.jiW = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.rd(this.jjr);
                            postData.a(subPostList, context);
                            this.jiN.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.jiS.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.jiU = new com.baidu.tbadk.data.c();
                    this.jiU.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.jiV = new com.baidu.tbadk.data.f();
                    this.jiV.a(post.lbs_info);
                }
                this.bLp = post.storecount.intValue();
                this.jiR.a(post.present);
                this.bKR.setUserMap(this.userMap);
                this.bKR.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.ier = new SmallTailInfo();
                    this.ier.id = post.signature.signature_id.intValue();
                    this.ier.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.ier.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.ier.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.ier.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.bLC.add(cVar);
                    }
                }
                this.bLF = post.skin_info;
                this.bLI = post.lego_card;
                this.jjf = post.tpoint_post;
                if (post.agree != null) {
                    this.jjg = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                    if (post.agree.disagree_num.longValue() >= 0) {
                        this.bMi = post.agree.disagree_num.longValue();
                    } else {
                        this.bMi = 0L;
                    }
                    this.bMk = post.agree.agree_type.intValue();
                    this.agreeData.postId = this.id;
                    this.agreeData.agreeType = post.agree.agree_type == null ? 0 : post.agree.agree_type.intValue();
                    this.agreeData.hasAgree = post.agree.has_agree.intValue() == 1;
                    this.agreeData.agreeNum = this.agreeNum;
                    this.agreeData.disAgreeNum = this.bMi;
                    this.agreeData.diffAgreeNum = post.agree.diff_agree_num == null ? 0L : post.agree.diff_agree_num.longValue();
                } else {
                    this.jjg = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.bMi < 0) {
                    this.bMi = 0L;
                }
                this.jjm = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.bMt = new OriginalThreadInfo();
                    this.bMt.parser(post.origin_thread_info);
                } else {
                    this.bMt = null;
                }
                this.jjp = post.is_fold.intValue();
                this.hKK = post.fold_tip;
                this.jjt = post.is_top_agree_post.intValue() == 1;
                this.jju = post.show_squared.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int icl;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(this.icl));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> jjD;
        private b jjE;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.jjD = new SoftReference<>(context);
            this.jjE = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.jjD != null) {
                if (this.jjE != null) {
                    this.jjE.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.jjD.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String eo(Context context) {
        ArrayList<TbRichTextData> ayZ;
        if (this.jiQ == null || (ayZ = this.jiQ.ayZ()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = ayZ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.azh().toString());
            } else if (next.getType() == 17) {
                String str = next.azl().mGifInfo.mSharpText;
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

    public String cqE() {
        ArrayList<TbRichTextData> ayZ;
        String str;
        if (this.jiQ == null || (ayZ = this.jiQ.ayZ()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = ayZ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.azh().toString());
                } else if (next.getType() == 17) {
                    if (next.azl() != null && next.azl().mGifInfo != null && (str = next.azl().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cqF() {
        ArrayList<TbRichTextData> ayZ;
        if (this.jiQ != null && (ayZ = this.jiQ.ayZ()) != null) {
            Iterator<TbRichTextData> it = ayZ.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.azg().getWidth();
                    preLoadImageInfo.height = next.azg().getHeight();
                    preLoadImageInfo.imgUrl = next.azg().azu();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.azm().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.azm().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.azm().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cqG() {
        k cqc;
        PreLoadImageInfo cqF = cqF();
        if (cqF != null && !StringUtils.isNull(cqF.imgUrl)) {
            return cqF.imgUrl;
        }
        if (this.jiY != null && (cqc = this.jiY.cqc()) != null && !StringUtils.isNull(cqc.cqh())) {
            return cqc.cqh();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> ayZ;
        if (this.jiQ == null || (ayZ = this.jiQ.ayZ()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = ayZ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.azg().getWidth();
                preLoadImageInfo.height = next.azg().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.azg().azz()) {
                    preLoadImageInfo.imgUrl = next.azg().azv();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.azg().azu();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.azl() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.azl().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.azl().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.azl();
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
        if (this.bKE == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.bKE.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.jiI == 52) {
            return jiE;
        }
        if (this.jiI == 1) {
            return bLG;
        }
        if (this.jiI == 36) {
            return jiB;
        }
        if (this.jiI == 40 || this.jiI == 50) {
            return bKa;
        }
        if (this.jiI == 41) {
            return jiC;
        }
        if (this.jiI == 53) {
            return jiF;
        }
        if (cqz() == 1) {
            return jiz;
        }
        return jiA;
    }

    public void setPostType(int i) {
        this.jiI = i;
    }

    public ao cqH() {
        return this.jiR;
    }

    public void a(ao aoVar) {
        this.jiR = aoVar;
    }

    public i cqI() {
        return this.jiY;
    }

    public com.baidu.tbadk.widget.richText.f azk() {
        if (this.jjc != null) {
            return this.jjc;
        }
        if (this.jiQ != null && v.Z(this.jiQ.ayZ()) > 0) {
            Iterator<TbRichTextData> it = this.jiQ.ayZ().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.jjc = next.azk();
                    return this.jjc;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo azi() {
        if (this.cdm != null) {
            return this.cdm;
        }
        if (this.jiQ != null && v.Z(this.jiQ.ayZ()) > 0) {
            Iterator<TbRichTextData> it = this.jiQ.ayZ().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.cdm = next.azi();
                    return this.cdm;
                }
            }
        }
        return null;
    }

    public String cqJ() {
        return this.jjd;
    }

    public String afE() {
        return this.bLI;
    }

    public void afG() {
        if (this.bLe == 0) {
            this.bLe = 1;
        }
    }

    public long afV() {
        return this.agreeNum;
    }

    public long afW() {
        return this.bMi;
    }

    public void as(long j) {
        this.agreeNum = j;
    }

    public boolean bpo() {
        return this.hasAgree;
    }

    public void hs(int i) {
        this.bMk = i;
    }

    public void ri(boolean z) {
        this.hasAgree = z;
    }

    public int afY() {
        return this.bMk;
    }

    public void at(long j) {
        this.bMi = j;
    }

    public AgreeData ags() {
        return this.agreeData;
    }

    public OriginalThreadInfo cqK() {
        return this.bMt;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.bMt = originalThreadInfo;
    }

    public int cqL() {
        return this.jjp;
    }

    public String bTG() {
        return this.hKK;
    }

    public boolean cqM() {
        return this.jju;
    }
}
