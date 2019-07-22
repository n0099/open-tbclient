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
    private long bLF;
    private int bLH;
    private OriginalThreadInfo bLQ;
    private SkinInfo bLc;
    private String bLf;
    private String bimg_url;
    private TbRichTextVoiceInfo ccl;
    private String hHW;
    private String hHl;
    private SmallTailInfo ibs;
    private String jfA;
    private String jfB;
    private TPointPost jfC;
    public int jfF;
    public AlaLiveInfoCoreData jfK;
    private boolean jfO;
    private boolean jfR;
    public an jfT;
    private ArrayList<PostData> jfk;
    private com.baidu.tbadk.data.c jfr;
    private com.baidu.tbadk.data.f jfs;
    private i jfv;
    private bc jfw;
    public boolean jfy;
    private com.baidu.tbadk.widget.richText.f jfz;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId jeW = BdUniqueId.gen();
    public static final BdUniqueId jeX = BdUniqueId.gen();
    public static final BdUniqueId bLd = BdUniqueId.gen();
    public static final BdUniqueId jeY = BdUniqueId.gen();
    public static final BdUniqueId bJx = BdUniqueId.gen();
    public static final BdUniqueId jeZ = BdUniqueId.gen();
    public static final BdUniqueId jfa = BdUniqueId.gen();
    public static final BdUniqueId jfb = BdUniqueId.gen();
    public static final BdUniqueId jfc = BdUniqueId.gen();
    public static final BdUniqueId jfd = BdUniqueId.gen();
    public static boolean jfe = false;
    private int jff = 0;
    private boolean jfl = false;
    private ArrayList<PostData> jfm = null;
    private TbRichText jfn = null;
    private boolean jfq = false;
    private boolean jft = false;
    private boolean jfu = false;
    public boolean jfx = false;
    public int bKB = 0;
    private boolean jfD = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean fBh = false;
    public boolean jfE = false;
    public boolean jfG = false;
    public boolean jfH = true;
    public boolean jfI = false;
    public boolean jfJ = false;
    private boolean jfL = false;
    private int jfM = 0;
    private boolean jfN = true;
    public boolean jfP = false;
    public boolean jfQ = false;
    public boolean jfS = false;
    private b jfU = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.jfT != null) {
                an ajh = PostData.this.jfT.ajh();
                ajh.nV("obj_locate");
                ajh.P("obj_locate", 7);
                TiebaStatic.log(ajh);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int jfg = 0;
    private long time = 0;
    private String date = null;
    private MetaData bKb = new MetaData();
    private ArrayList<l> jfh = new ArrayList<>();
    private ArrayList<l> jfi = new ArrayList<>();
    private int jfj = 0;
    private int bKM = 0;
    private PraiseData bKo = new PraiseData();
    private ao jfo = new ao();
    private c jfp = new c();
    private ArrayList<com.baidu.tbadk.data.c> bKZ = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.jfk = null;
        this.jfF = 0;
        this.jfk = new ArrayList<>();
        this.jfF = 0;
    }

    public void qZ(boolean z) {
        this.jfO = z;
    }

    public boolean cph() {
        return this.jfO;
    }

    public ArrayList<PostData> cpi() {
        return this.jfm;
    }

    public void cpj() {
        this.jfm.clear();
        this.jfm = null;
        this.jfl = false;
    }

    public void r(PostData postData) {
        if (postData != null) {
            if (this.jfm == null) {
                this.jfm = new ArrayList<>();
                if (v.Z(this.jfk) > 2) {
                    this.jfm.addAll(v.c(this.jfk, 0, 2));
                } else {
                    this.jfm.addAll(this.jfk);
                }
            }
            this.jfm.add(postData);
        }
    }

    public void s(PostData postData) {
        if (postData != null && this.jfk != null) {
            this.jfk.add(postData);
            cpn();
        }
    }

    public void EJ(String str) {
        if (this.jfm != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.jfm.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.jfm.remove(next);
                    return;
                }
            }
        }
    }

    public void ra(boolean z) {
        this.jfN = z;
    }

    public boolean cpk() {
        return this.jfN;
    }

    public void rb(boolean z) {
        this.jfl = z;
    }

    public boolean cpl() {
        return this.jfl;
    }

    public ArrayList<PostData> cpm() {
        return this.jfk;
    }

    public void cpn() {
        this.jfj++;
    }

    public void cpo() {
        this.jfj--;
    }

    public void Bd(int i) {
        this.jfj = i;
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

    public String bSr() {
        return this.hHl;
    }

    public int cpp() {
        return this.jfg;
    }

    public void Be(int i) {
        this.jfg = i;
    }

    public boolean cpq() {
        return this.jfu;
    }

    public void rc(boolean z) {
        this.jfu = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = aq.aD(j);
    }

    public MetaData aex() {
        return this.bKb;
    }

    public void a(MetaData metaData) {
        this.bKb = metaData;
    }

    public void a(PraiseData praiseData) {
        this.bKo = praiseData;
    }

    public TbRichText cpr() {
        return this.jfn;
    }

    public void c(TbRichText tbRichText) {
        this.jfn = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bZx() {
        return this.ibs;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.ibs = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cps() {
        return this.jfs;
    }

    public SkinInfo aeS() {
        return this.bLc;
    }

    public void rd(boolean z) {
        this.jfL = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.jfn != null && this.jfn.ayL() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.bKb != null && this.bKb.getIs_bawu() == 1) {
                    if (this.jfO) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.bKb.getBawu_type())) {
                        str = " 吧主";
                    } else if ("assist".equals(this.bKb.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.bKb.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.bKb.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = aex().getTShowInfoNew();
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
                                            PostData.this.jfn.isChanged = true;
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
            if (!StringUtils.isNull(this.bKb.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.bKb.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.bKb == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.bKb.getName_show() + str + "：");
                str2 = this.bKb.getUserName();
                str3 = this.bKb.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.bKb.getSealPrefix())) {
                Bitmap ij = am.ij(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(ij);
                if (ij != null) {
                    bitmapDrawable.setBounds(0, 0, ij.getWidth(), ij.getHeight());
                }
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.bKb.getSealPrefix().length() + 1;
                spannableString.setSpan(kVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.jfU), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.bKb != null && this.bKb.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.c am = am(z, this.bKb != null && this.bKb.getIs_bawu() == 1);
                if (am != null) {
                    if (this.bKb != null) {
                        int i3 = 0;
                        if (this.bKb.getName_show() != null) {
                            i3 = this.bKb.getName_show().length();
                        }
                        spannableString.setSpan(am, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(am, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> ayL = this.jfn.ayL();
            if (ayL != null && ayL.size() > 0) {
                TbRichTextData tbRichTextData2 = ayL.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.ayT() != null) {
                    if (this.jfL) {
                        int indexOf = tbRichTextData2.ayT().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.ayT().delete(0, indexOf + 1);
                        }
                        this.jfL = false;
                    }
                    tbRichTextData2.lE(sb.length());
                    tbRichTextData2.ayT().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= ayL.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (ayL.get(i5) == null || ayL.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo ayU = ayL.get(i5).ayU();
                            ayL.remove(i5);
                            tbRichTextVoiceInfo = ayU;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.lE(sb.length());
                    tbRichTextData.k(spannableString);
                    ayL.add(0, tbRichTextData);
                }
            }
            this.jfP = true;
        }
    }

    private com.baidu.tbadk.core.view.c am(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds5), this.jfO ? R.color.cp_link_tip_a_alpha50 : R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds26), this.jfO ? R.color.cp_link_tip_a : R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds40));
        if (this.jfO) {
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

    public int cpt() {
        return this.jfj;
    }

    public void ek(Context context) {
        int type;
        int i;
        int i2;
        if (this.jfh != null) {
            int i3 = -1;
            int size = this.jfi.size();
            if (size > 0) {
                try {
                    i3 = this.jfi.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.jfh.size()) {
                l lVar = this.jfh.get(i4);
                if (l.cA(i5, lVar.getType())) {
                    this.jfi.get(size - 1).b(lVar.ej(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.jfi.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.ej(context));
                        this.jfi.add(lVar2);
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

    public void el(Context context) {
        try {
            if (this.jfn != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.jfn.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.jfi == null || this.jfi.size() == 0) {
                ek(context);
            }
            ArrayList<l> arrayList = this.jfi;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cpa() != null) {
                            sb.append((CharSequence) next.cpa());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String qh = TbFaceManager.atv().qh(next.getText());
                        if (qh != null) {
                            sb.append("[");
                            sb.append(qh);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aq.isEmpty(next.coZ())) {
                        sb.append("[").append(next.coZ()).append("]");
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
                this.jfg = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = aq.aD(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.jft = subPostList.is_giftpost.intValue() == 1;
                this.agree = subPostList.agree;
                if (this.agree != null) {
                    this.bLH = this.agree.agree_type.intValue();
                    this.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeNum = this.agree.agree_num.longValue() > 0 ? this.agree.agree_num.longValue() : 0L;
                    this.bLF = this.agree.disagree_num.longValue() > 0 ? this.agree.disagree_num.longValue() : 0L;
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
                    this.bKb = metaData;
                }
                if ((this.bKb.getUserId() == null || this.bKb.getUserId().length() <= 0 || this.bKb.getUserId().equals("0")) && metaData2 != null) {
                    this.bKb = metaData2;
                }
                this.jfn = TbRichTextView.a(context, subPostList.content, z);
                if (this.jfn != null) {
                    this.jfn.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.jfg = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = aq.aD(this.time);
                this.hHl = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bKb = metaData;
                }
                this.fBh = post.need_log.intValue() == 1;
                this.jfE = post.img_num_abtest.intValue() == 1;
                this.jfw = new bc();
                this.jfw.parserProtobuf(post.from_forum);
                if (this.bKb.getUserId() == null || this.bKb.getUserId().length() <= 0 || this.bKb.getUserId().equals("0")) {
                    this.bKb.parserProtobuf(post.author);
                }
                if (this.bKb != null && context != null) {
                    this.jfA = this.bKb.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.jfB = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.bKb.getLevel_id()));
                }
                this.jfq = post.is_ntitle.intValue() == 1;
                this.jfj = post.sub_post_number.intValue();
                this.jfv = new i(post.tpoint_post);
                this.jfn = TbRichTextView.a(context, post.content, true);
                if (this.jfn != null) {
                    this.jfn.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.jfn.lD(this.jfg);
                    if (this.bKb != null) {
                        this.jfn.setAuthorId(this.bKb.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.jft = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.qZ(this.jfO);
                            postData.a(subPostList, context);
                            this.jfk.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.jfp.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.jfr = new com.baidu.tbadk.data.c();
                    this.jfr.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.jfs = new com.baidu.tbadk.data.f();
                    this.jfs.a(post.lbs_info);
                }
                this.bKM = post.storecount.intValue();
                this.jfo.a(post.present);
                this.bKo.setUserMap(this.userMap);
                this.bKo.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.ibs = new SmallTailInfo();
                    this.ibs.id = post.signature.signature_id.intValue();
                    this.ibs.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.ibs.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.ibs.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.ibs.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.bKZ.add(cVar);
                    }
                }
                this.bLc = post.skin_info;
                this.bLf = post.lego_card;
                this.jfC = post.tpoint_post;
                if (post.agree != null) {
                    this.jfD = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                    if (post.agree.disagree_num.longValue() >= 0) {
                        this.bLF = post.agree.disagree_num.longValue();
                    } else {
                        this.bLF = 0L;
                    }
                    this.bLH = post.agree.agree_type.intValue();
                    this.agreeData.postId = this.id;
                    this.agreeData.agreeType = post.agree.agree_type == null ? 0 : post.agree.agree_type.intValue();
                    this.agreeData.hasAgree = post.agree.has_agree.intValue() == 1;
                    this.agreeData.agreeNum = this.agreeNum;
                    this.agreeData.disAgreeNum = this.bLF;
                    this.agreeData.diffAgreeNum = post.agree.diff_agree_num == null ? 0L : post.agree.diff_agree_num.longValue();
                } else {
                    this.jfD = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.bLF < 0) {
                    this.bLF = 0L;
                }
                this.jfJ = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.bLQ = new OriginalThreadInfo();
                    this.bLQ.parser(post.origin_thread_info);
                } else {
                    this.bLQ = null;
                }
                this.jfM = post.is_fold.intValue();
                this.hHW = post.fold_tip;
                this.jfQ = post.is_top_agree_post.intValue() == 1;
                this.jfR = post.show_squared.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int hZr;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(this.hZr));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> jga;
        private b jgb;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.jga = new SoftReference<>(context);
            this.jgb = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.jga != null) {
                if (this.jgb != null) {
                    this.jgb.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.jga.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String em(Context context) {
        ArrayList<TbRichTextData> ayL;
        if (this.jfn == null || (ayL = this.jfn.ayL()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = ayL.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.ayT().toString());
            } else if (next.getType() == 17) {
                String str = next.ayX().mGifInfo.mSharpText;
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

    public String cpu() {
        ArrayList<TbRichTextData> ayL;
        String str;
        if (this.jfn == null || (ayL = this.jfn.ayL()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = ayL.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.ayT().toString());
                } else if (next.getType() == 17) {
                    if (next.ayX() != null && next.ayX().mGifInfo != null && (str = next.ayX().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cpv() {
        ArrayList<TbRichTextData> ayL;
        if (this.jfn != null && (ayL = this.jfn.ayL()) != null) {
            Iterator<TbRichTextData> it = ayL.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.ayS().getWidth();
                    preLoadImageInfo.height = next.ayS().getHeight();
                    preLoadImageInfo.imgUrl = next.ayS().azg();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.ayY().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.ayY().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.ayY().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cpw() {
        k coS;
        PreLoadImageInfo cpv = cpv();
        if (cpv != null && !StringUtils.isNull(cpv.imgUrl)) {
            return cpv.imgUrl;
        }
        if (this.jfv != null && (coS = this.jfv.coS()) != null && !StringUtils.isNull(coS.coX())) {
            return coS.coX();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> ayL;
        if (this.jfn == null || (ayL = this.jfn.ayL()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = ayL.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.ayS().getWidth();
                preLoadImageInfo.height = next.ayS().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.ayS().azl()) {
                    preLoadImageInfo.imgUrl = next.ayS().azh();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.ayS().azg();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.ayX() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.ayX().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.ayX().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.ayX();
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
        if (this.bKb == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.bKb.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.jff == 52) {
            return jfb;
        }
        if (this.jff == 1) {
            return bLd;
        }
        if (this.jff == 36) {
            return jeY;
        }
        if (this.jff == 40 || this.jff == 50) {
            return bJx;
        }
        if (this.jff == 41) {
            return jeZ;
        }
        if (this.jff == 53) {
            return jfc;
        }
        if (cpp() == 1) {
            return jeW;
        }
        return jeX;
    }

    public void setPostType(int i) {
        this.jff = i;
    }

    public ao cpx() {
        return this.jfo;
    }

    public void a(ao aoVar) {
        this.jfo = aoVar;
    }

    public i cpy() {
        return this.jfv;
    }

    public com.baidu.tbadk.widget.richText.f ayW() {
        if (this.jfz != null) {
            return this.jfz;
        }
        if (this.jfn != null && v.Z(this.jfn.ayL()) > 0) {
            Iterator<TbRichTextData> it = this.jfn.ayL().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.jfz = next.ayW();
                    return this.jfz;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo ayU() {
        if (this.ccl != null) {
            return this.ccl;
        }
        if (this.jfn != null && v.Z(this.jfn.ayL()) > 0) {
            Iterator<TbRichTextData> it = this.jfn.ayL().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.ccl = next.ayU();
                    return this.ccl;
                }
            }
        }
        return null;
    }

    public String cpz() {
        return this.jfA;
    }

    public String afz() {
        return this.bLf;
    }

    public void afB() {
        if (this.bKB == 0) {
            this.bKB = 1;
        }
    }

    public long afQ() {
        return this.agreeNum;
    }

    public long afR() {
        return this.bLF;
    }

    public void as(long j) {
        this.agreeNum = j;
    }

    public boolean boq() {
        return this.hasAgree;
    }

    public void hr(int i) {
        this.bLH = i;
    }

    public void re(boolean z) {
        this.hasAgree = z;
    }

    public int afT() {
        return this.bLH;
    }

    public void at(long j) {
        this.bLF = j;
    }

    public AgreeData agn() {
        return this.agreeData;
    }

    public OriginalThreadInfo cpA() {
        return this.bLQ;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.bLQ = originalThreadInfo;
    }

    public int cpB() {
        return this.jfM;
    }

    public String bSF() {
        return this.hHW;
    }

    public boolean cpC() {
        return this.jfR;
    }
}
