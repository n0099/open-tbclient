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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.e;
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
public class PostData implements com.baidu.adp.widget.ListView.h, ae {
    private TbRichTextVoiceInfo aAY;
    private Agree agree;
    private SkinInfo alC;
    private String alF;
    private long ama;
    private int amc;
    private OriginalThreadInfo aml;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private boolean fBf;
    private SmallTailInfo fTA;
    private String fzT;
    private ArrayList<PostData> gVL;
    private com.baidu.tbadk.data.c gVS;
    private com.baidu.tbadk.data.f gVT;
    private h gVW;
    private ay gVX;
    public boolean gVZ;
    private com.baidu.tbadk.widget.richText.f gWa;
    private String gWb;
    private String gWc;
    private TPointPost gWd;
    public int gWg;
    public AlaLiveInfoCoreData gWl;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId gVz = BdUniqueId.gen();
    public static final BdUniqueId gVA = BdUniqueId.gen();
    public static final BdUniqueId alD = BdUniqueId.gen();
    public static final BdUniqueId gVB = BdUniqueId.gen();
    public static final BdUniqueId aka = BdUniqueId.gen();
    public static final BdUniqueId gVC = BdUniqueId.gen();
    public static final BdUniqueId gVD = BdUniqueId.gen();
    public static final BdUniqueId gVE = BdUniqueId.gen();
    public static final BdUniqueId gVF = BdUniqueId.gen();
    public static boolean gVG = false;
    private int gVH = 0;
    private boolean gVM = false;
    private ArrayList<PostData> gVN = null;
    private TbRichText gVO = null;
    private boolean gVR = false;
    private boolean gVU = false;
    private boolean gVV = false;
    public boolean gVY = false;
    public int alb = 0;
    private boolean gWe = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean dyT = false;
    public boolean gWf = false;
    public boolean gWh = false;
    public boolean gWi = true;
    public boolean gWj = false;
    public boolean gWk = false;
    private boolean gWm = false;
    private int gWn = 0;
    private boolean gWo = true;
    public boolean gWp = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData akB = new MetaData();
    private ArrayList<k> gVI = new ArrayList<>();
    private ArrayList<k> gVJ = new ArrayList<>();
    private int gVK = 0;
    private int alm = 0;
    private PraiseData akO = new PraiseData();
    private am gVP = new am();
    private c gVQ = new c();
    private ArrayList<com.baidu.tbadk.data.c> alz = new ArrayList<>();

    public PostData() {
        this.gVL = null;
        this.gWg = 0;
        this.gVL = new ArrayList<>();
        this.gWg = 0;
    }

    public void jT(boolean z) {
        this.fBf = z;
    }

    public boolean byE() {
        return this.fBf;
    }

    public ArrayList<PostData> byF() {
        return this.gVN;
    }

    public void byG() {
        this.gVN.clear();
        this.gVN = null;
        this.gVM = false;
    }

    public void p(PostData postData) {
        if (postData != null) {
            if (this.gVN == null) {
                this.gVN = new ArrayList<>();
                if (v.y(this.gVL) > 2) {
                    this.gVN.addAll(v.b(this.gVL, 0, 2));
                } else {
                    this.gVN.addAll(this.gVL);
                }
            }
            this.gVN.add(postData);
        }
    }

    public void q(PostData postData) {
        if (postData != null && this.gVL != null) {
            this.gVL.add(postData);
            byK();
        }
    }

    public void uv(String str) {
        if (this.gVN != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.gVN.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.gVN.remove(next);
                    return;
                }
            }
        }
    }

    public void mN(boolean z) {
        this.gWo = z;
    }

    public boolean byH() {
        return this.gWo;
    }

    public void mO(boolean z) {
        this.gVM = z;
    }

    public boolean byI() {
        return this.gVM;
    }

    public ArrayList<PostData> byJ() {
        return this.gVL;
    }

    public void byK() {
        this.gVK++;
    }

    public void byL() {
        this.gVK--;
    }

    public void ui(int i) {
        this.gVK = i;
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

    public void setTitle(String str) {
        this.title = str;
    }

    public String bbC() {
        return this.fzT;
    }

    public int byM() {
        return this.floor_num;
    }

    public void uj(int i) {
        this.floor_num = i;
    }

    public boolean byN() {
        return this.gVV;
    }

    public void mP(boolean z) {
        this.gVV = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ao.A(j);
    }

    public MetaData wm() {
        return this.akB;
    }

    public void a(MetaData metaData) {
        this.akB = metaData;
    }

    public void a(PraiseData praiseData) {
        this.akO = praiseData;
    }

    public TbRichText byO() {
        return this.gVO;
    }

    public void c(TbRichText tbRichText) {
        this.gVO = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bix() {
        return this.fTA;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.fTA = smallTailInfo;
    }

    public com.baidu.tbadk.data.f byP() {
        return this.gVT;
    }

    public SkinInfo wI() {
        return this.alC;
    }

    public void mQ(boolean z) {
        this.gWm = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.gVO != null && this.gVO.OP() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.akB != null && this.akB.getIs_bawu() == 1) {
                    if (this.fBf) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.akB.getBawu_type())) {
                        str = " 吧主";
                    } else if ("assist".equals(this.akB.getBawu_type())) {
                        str = " 小吧主";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = wm().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jn().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.jn().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((C02431) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.oi()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.gVO.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.d(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(e.C0141e.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(e.C0141e.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.akB.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.akB.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.akB == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.akB.getName_show() + str + "：");
                str2 = this.akB.getUserName();
                str3 = this.akB.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.akB.getSealPrefix())) {
                Bitmap dc = al.dc(e.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(dc);
                if (dc != null) {
                    bitmapDrawable.setBounds(0, 0, dc.getWidth(), dc.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), e.C0141e.ds2));
                int size = arrayList.size() + this.akB.getSealPrefix().length() + 1;
                spannableString.setSpan(mVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.akB != null && this.akB.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.e U = U(z, this.akB != null && this.akB.getIs_bawu() == 1);
                if (U != null) {
                    if (this.akB != null) {
                        int i3 = 0;
                        if (this.akB.getName_show() != null) {
                            i3 = this.akB.getName_show().length();
                        }
                        spannableString.setSpan(U, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(U, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> OP = this.gVO.OP();
            if (OP != null && OP.size() > 0) {
                TbRichTextData tbRichTextData2 = OP.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.OW() != null) {
                    if (this.gWm) {
                        int indexOf = tbRichTextData2.OW().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.OW().delete(0, indexOf + 1);
                        }
                        this.gWm = false;
                    }
                    tbRichTextData2.gk(sb.length());
                    tbRichTextData2.OW().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= OP.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (OP.get(i5) == null || OP.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo OX = OP.get(i5).OX();
                            OP.remove(i5);
                            tbRichTextVoiceInfo = OX;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.gk(sb.length());
                    tbRichTextData.append(spannableString);
                    OP.add(0, tbRichTextData);
                }
            }
            this.gWp = true;
        }
    }

    private com.baidu.tbadk.core.view.e U(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        return new com.baidu.tbadk.core.view.e(com.baidu.adp.lib.util.l.h(context, e.C0141e.tbds1), com.baidu.adp.lib.util.l.h(context, e.C0141e.tbds4), this.fBf ? e.d.cp_link_tip_a_alpha50 : e.d.cp_cont_j_alpha50, com.baidu.adp.lib.util.l.h(context, e.C0141e.tbds30), this.fBf ? e.d.cp_link_tip_a : e.d.cp_cont_j, com.baidu.adp.lib.util.l.h(context, e.C0141e.tbds12), com.baidu.adp.lib.util.l.h(context, e.C0141e.tbds42));
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap oh;
        if (aVar == null || (oh = aVar.oh()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(oh);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(e.C0141e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(e.C0141e.ds36));
        return bitmapDrawable;
    }

    public int byQ() {
        return this.gVK;
    }

    public void cN(Context context) {
        int type;
        int i;
        int i2;
        if (this.gVI != null) {
            int i3 = -1;
            int size = this.gVJ.size();
            if (size > 0) {
                try {
                    i3 = this.gVJ.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.gVI.size()) {
                k kVar = this.gVI.get(i4);
                if (k.bM(i5, kVar.getType())) {
                    this.gVJ.get(size - 1).b(kVar.cM(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.gVJ.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.cM(context));
                        this.gVJ.add(kVar2);
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

    public void cO(Context context) {
        try {
            if (this.gVO != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.gVO.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.gVJ == null || this.gVJ.size() == 0) {
                cN(context);
            }
            ArrayList<k> arrayList = this.gVJ;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.byx() != null) {
                            sb.append((CharSequence) next.byx());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(e.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(e.j.voice_str));
                    } else if (next.getType() == 2) {
                        String gY = TbFaceManager.Kf().gY(next.getText());
                        if (gY != null) {
                            sb.append("[");
                            sb.append(gY);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ao.isEmpty(next.byw())) {
                        sb.append("[").append(next.byw()).append("]");
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
                this.date = ao.A(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.gVU = subPostList.is_giftpost.intValue() == 1;
                this.agree = subPostList.agree;
                if (this.agree != null) {
                    this.amc = this.agree.agree_type.intValue();
                    this.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeNum = this.agree.agree_num.longValue() > 0 ? this.agree.agree_num.longValue() : 0L;
                    this.ama = this.agree.disagree_num.longValue() > 0 ? this.agree.disagree_num.longValue() : 0L;
                }
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.akB = metaData;
                }
                if ((this.akB.getUserId() == null || this.akB.getUserId().length() <= 0 || this.akB.getUserId().equals("0")) && metaData2 != null) {
                    this.akB = metaData2;
                }
                this.gVO = TbRichTextView.a(context, subPostList.content, z);
                if (this.gVO != null) {
                    this.gVO.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
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
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = ao.A(this.time);
                this.fzT = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.akB = metaData;
                }
                this.dyT = post.need_log.intValue() == 1;
                this.gWf = post.img_num_abtest.intValue() == 1;
                this.gVX = new ay();
                this.gVX.parserProtobuf(post.from_forum);
                if (this.akB.getUserId() == null || this.akB.getUserId().length() <= 0 || this.akB.getUserId().equals("0")) {
                    this.akB.parserProtobuf(post.author);
                }
                if (this.akB != null && context != null) {
                    this.gWb = this.akB.getUserName() + context.getResources().getString(e.j.somebodys_portrait);
                    this.gWc = String.format(TbadkCoreApplication.getInst().getString(e.j.degree_in_forum), Integer.valueOf(this.akB.getLevel_id()));
                }
                this.gVR = post.is_ntitle.intValue() == 1;
                this.gVK = post.sub_post_number.intValue();
                this.gVW = new h(post.tpoint_post);
                this.gVO = TbRichTextView.a(context, post.content, true);
                if (this.gVO != null) {
                    this.gVO.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
                    this.gVO.gj(this.floor_num);
                    if (this.akB != null) {
                        this.gVO.setAuthorId(this.akB.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.gVU = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.jT(this.fBf);
                            postData.a(subPostList, context);
                            this.gVL.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.gVQ.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.gVS = new com.baidu.tbadk.data.c();
                    this.gVS.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.gVT = new com.baidu.tbadk.data.f();
                    this.gVT.a(post.lbs_info);
                }
                this.alm = post.storecount.intValue();
                this.gVP.a(post.present);
                this.akO.setUserMap(this.userMap);
                this.akO.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.fTA = new SmallTailInfo();
                    this.fTA.id = post.signature.signature_id.intValue();
                    this.fTA.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.fTA.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.fTA.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.fTA.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.alz.add(cVar);
                    }
                }
                this.alC = post.skin_info;
                this.alF = post.lego_card;
                this.gWd = post.tpoint_post;
                if (post.agree != null) {
                    this.gWe = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                    if (post.agree.disagree_num.longValue() >= 0) {
                        this.ama = post.agree.disagree_num.longValue();
                    } else {
                        this.ama = 0L;
                    }
                    this.amc = post.agree.agree_type.intValue();
                } else {
                    this.gWe = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.ama < 0) {
                    this.ama = 0L;
                }
                this.gWk = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.aml = new OriginalThreadInfo();
                    this.aml.parser(post.origin_thread_info);
                } else {
                    this.aml = null;
                }
                this.gWn = post.is_fold.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int fRH;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(this.fRH));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> gWv;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.gWv = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(e.d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.gWv != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.gWv.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String cP(Context context) {
        ArrayList<TbRichTextData> OP;
        if (this.gVO == null || (OP = this.gVO.OP()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = OP.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.OW().toString());
            } else if (next.getType() == 17) {
                String str = next.Pa().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(e.j.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(e.j.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(e.j.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String byR() {
        ArrayList<TbRichTextData> OP;
        String str;
        if (this.gVO == null || (OP = this.gVO.OP()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = OP.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.OW().toString());
                } else if (next.getType() == 17) {
                    if (next.Pa() != null && next.Pa().mGifInfo != null && (str = next.Pa().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo byS() {
        ArrayList<TbRichTextData> OP;
        if (this.gVO != null && (OP = this.gVO.OP()) != null) {
            Iterator<TbRichTextData> it = OP.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.OV().getWidth();
                    preLoadImageInfo.height = next.OV().getHeight();
                    preLoadImageInfo.imgUrl = next.OV().Pk();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.Pb().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.Pb().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.Pb().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String byT() {
        j byp;
        PreLoadImageInfo byS = byS();
        if (byS != null && !StringUtils.isNull(byS.imgUrl)) {
            return byS.imgUrl;
        }
        if (this.gVW != null && (byp = this.gVW.byp()) != null && !StringUtils.isNull(byp.byu())) {
            return byp.byu();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> OP;
        if (this.gVO == null || (OP = this.gVO.OP()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = OP.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.OV().getWidth();
                preLoadImageInfo.height = next.OV().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.OV().Pp()) {
                    preLoadImageInfo.imgUrl = next.OV().Pl();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.OV().Pk();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.Pa() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.Pa().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.Pa().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.Pa();
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
        if (this.akB == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.akB.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.gVH == 52) {
            return gVD;
        }
        if (this.gVH == 1) {
            return alD;
        }
        if (this.gVH == 36) {
            return gVB;
        }
        if (this.gVH == 40 || this.gVH == 50) {
            return aka;
        }
        if (this.gVH == 41) {
            return gVC;
        }
        if (this.gVH == 53) {
            return gVE;
        }
        if (byM() == 1) {
            return gVz;
        }
        return gVA;
    }

    public void setPostType(int i) {
        this.gVH = i;
    }

    public am byU() {
        return this.gVP;
    }

    public void a(am amVar) {
        this.gVP = amVar;
    }

    public h byV() {
        return this.gVW;
    }

    public com.baidu.tbadk.widget.richText.f OZ() {
        if (this.gWa != null) {
            return this.gWa;
        }
        if (this.gVO != null && v.y(this.gVO.OP()) > 0) {
            Iterator<TbRichTextData> it = this.gVO.OP().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.gWa = next.OZ();
                    return this.gWa;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo OX() {
        if (this.aAY != null) {
            return this.aAY;
        }
        if (this.gVO != null && v.y(this.gVO.OP()) > 0) {
            Iterator<TbRichTextData> it = this.gVO.OP().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aAY = next.OX();
                    return this.aAY;
                }
            }
        }
        return null;
    }

    public String byW() {
        return this.gWb;
    }

    public String xg() {
        return this.alF;
    }

    public void xj() {
        if (this.alb == 0) {
            this.alb = 1;
        }
    }

    public long xy() {
        return this.agreeNum;
    }

    public long xz() {
        return this.ama;
    }

    public void t(long j) {
        this.agreeNum = j;
    }

    public boolean ayA() {
        return this.hasAgree;
    }

    public void cm(int i) {
        this.amc = i;
    }

    public void mR(boolean z) {
        this.hasAgree = z;
    }

    public int xB() {
        return this.amc;
    }

    public void u(long j) {
        this.ama = j;
    }

    public OriginalThreadInfo byX() {
        return this.aml;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.aml = originalThreadInfo;
    }

    public int byY() {
        return this.gWn;
    }
}
