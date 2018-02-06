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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.m;
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
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements com.baidu.adp.widget.ListView.i, ae {
    private SkinInfo aPO;
    private String aPR;
    private OriginalThreadInfo aQw;
    @Deprecated
    private String authorId;
    private TbRichTextVoiceInfo bel;
    private String bimg_url;
    private String fHb;
    private SmallTailInfo gaY;
    public AlaLiveInfoCoreData hbB;
    private ArrayList<PostData> hba;
    private com.baidu.tbadk.data.c hbh;
    private com.baidu.tbadk.data.f hbi;
    private h hbl;
    private ay hbm;
    public boolean hbo;
    private com.baidu.tbadk.widget.richText.f hbp;
    private String hbq;
    private String hbr;
    private TPointPost hbs;
    public int hbw;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId haP = BdUniqueId.gen();
    public static final BdUniqueId haQ = BdUniqueId.gen();
    public static final BdUniqueId aPP = BdUniqueId.gen();
    public static final BdUniqueId haR = BdUniqueId.gen();
    public static final BdUniqueId aOx = BdUniqueId.gen();
    public static final BdUniqueId haS = BdUniqueId.gen();
    public static final BdUniqueId haT = BdUniqueId.gen();
    public static final BdUniqueId haU = BdUniqueId.gen();
    public static boolean haV = false;
    private int haW = 0;
    private boolean hbb = false;
    private ArrayList<PostData> hbc = null;
    private TbRichText hbd = null;
    private boolean hbg = false;
    private boolean hbj = false;
    private boolean hbk = false;
    public boolean hbn = false;
    public int aPo = 0;
    private boolean hbt = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean hbu = false;
    public boolean hbv = false;
    public boolean hbx = false;
    public boolean hby = true;
    public boolean hbz = false;
    public boolean hbA = false;
    private boolean hbC = false;
    private int hbD = 0;
    private boolean hbE = true;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData aOQ = new MetaData();
    private ArrayList<k> haX = new ArrayList<>();
    private ArrayList<k> haY = new ArrayList<>();
    private int haZ = 0;
    private int aPy = 0;
    private PraiseData aPc = new PraiseData();
    private am hbe = new am();
    private c hbf = new c();
    private ArrayList<com.baidu.tbadk.data.c> aPM = new ArrayList<>();

    public PostData() {
        this.hba = null;
        this.hbw = 0;
        this.hba = new ArrayList<>();
        this.hbw = 0;
    }

    public ArrayList<PostData> bwN() {
        return this.hbc;
    }

    public void bwO() {
        this.hbc.clear();
        this.hbc = null;
        this.hbb = false;
    }

    public void p(PostData postData) {
        if (postData != null) {
            if (this.hbc == null) {
                this.hbc = new ArrayList<>();
                if (v.D(this.hba) > 2) {
                    this.hbc.addAll(v.b(this.hba, 0, 2));
                } else {
                    this.hbc.addAll(this.hba);
                }
            }
            this.hbc.add(postData);
        }
    }

    public void q(PostData postData) {
        if (postData != null && this.hba != null) {
            this.hba.add(postData);
            bwS();
        }
    }

    public void sM(String str) {
        if (this.hbc != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.hbc.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.hbc.remove(next);
                    return;
                }
            }
        }
    }

    public void mG(boolean z) {
        this.hbE = z;
    }

    public boolean bwP() {
        return this.hbE;
    }

    public void mH(boolean z) {
        this.hbb = z;
    }

    public boolean bwQ() {
        return this.hbb;
    }

    public ArrayList<PostData> bwR() {
        return this.hba;
    }

    public void bwS() {
        this.haZ++;
    }

    public void bwT() {
        this.haZ--;
    }

    public void vK(int i) {
        this.haZ = i;
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

    public String bam() {
        return this.fHb;
    }

    public int bwU() {
        return this.floor_num;
    }

    public void vL(int i) {
        this.floor_num = i;
    }

    public boolean bwV() {
        return this.hbk;
    }

    public void mI(boolean z) {
        this.hbk = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = com.baidu.tbadk.core.util.am.z(j);
    }

    public String bwW() {
        return this.date;
    }

    public MetaData zn() {
        return this.aOQ;
    }

    public void a(MetaData metaData) {
        this.aOQ = metaData;
    }

    public void a(PraiseData praiseData) {
        this.aPc = praiseData;
    }

    public TbRichText bwX() {
        return this.hbd;
    }

    public void c(TbRichText tbRichText) {
        this.hbd = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bha() {
        return this.gaY;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.gaY = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bwY() {
        return this.hbi;
    }

    public SkinInfo zJ() {
        return this.aPO;
    }

    public void mJ(boolean z) {
        this.hbC = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.hbd != null && this.hbd.Ri() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else if (this.aOQ != null && this.aOQ.getIs_bawu() == 1 && "manager".equals(this.aOQ.getBawu_type())) {
                str = " 吧主";
            } else if (this.aOQ == null || this.aOQ.getIs_bawu() != 1 || !"assist".equals(this.aOQ.getBawu_type())) {
                str = "";
            } else {
                str = " 小吧";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = zn().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.nm().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.nm().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str4, int i) {
                                        super.onLoaded((C02361) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.si()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.hbd.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.k(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.aOQ.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.aOQ.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.aOQ == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.aOQ.getName_show() + str + "：");
                str2 = this.aOQ.getUserName();
                str3 = this.aOQ.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.aOQ.getSealPrefix())) {
                Bitmap fO = aj.fO(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(fO);
                if (fO != null) {
                    bitmapDrawable.setBounds(0, 0, fO.getWidth(), fO.getHeight());
                }
                m mVar = new m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.t(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.aOQ.getSealPrefix().length() + 1;
                spannableString.setSpan(mVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.aOQ != null && this.aOQ.getIs_bawu() == 1))) {
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.C0140d.cp_link_tip_a);
                if (this.aOQ != null) {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.aOQ.getName_show().length() + 1, str.length() + sb2.length() + this.aOQ.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> Ri = this.hbd.Ri();
            if (Ri != null && Ri.size() > 0) {
                TbRichTextData tbRichTextData2 = Ri.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.Rp() != null) {
                    if (this.hbC) {
                        int indexOf = tbRichTextData2.Rp().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.Rp().delete(0, indexOf + 1);
                        }
                        this.hbC = false;
                    }
                    tbRichTextData2.iU(sb.length());
                    tbRichTextData2.Rp().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Ri.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (Ri.get(i4) == null || Ri.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo Rq = Ri.get(i4).Rq();
                        Ri.remove(i4);
                        tbRichTextVoiceInfo = Rq;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.iU(sb.length());
                tbRichTextData.append(spannableString);
                Ri.add(0, tbRichTextData);
            }
        }
    }

    protected Drawable h(com.baidu.adp.widget.a.a aVar) {
        Bitmap sh;
        if (aVar == null || (sh = aVar.sh()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(sh);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36));
        return bitmapDrawable;
    }

    public int bwZ() {
        return this.haZ;
    }

    public void cj(Context context) {
        int type;
        int i;
        int i2;
        if (this.haX != null) {
            int i3 = -1;
            int size = this.haY.size();
            if (size > 0) {
                try {
                    i3 = this.haY.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.haX.size()) {
                k kVar = this.haX.get(i4);
                if (k.cH(i5, kVar.getType())) {
                    this.haY.get(size - 1).b(kVar.ci(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.haY.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.ci(context));
                        this.haY.add(kVar2);
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

    public void ck(Context context) {
        try {
            if (this.hbd != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.hbd.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.haY == null || this.haY.size() == 0) {
                cj(context);
            }
            ArrayList<k> arrayList = this.haY;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bwG() != null) {
                            sb.append((CharSequence) next.bwG());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.j.voice_str));
                    } else if (next.getType() == 2) {
                        String gm = TbFaceManager.Mw().gm(next.getText());
                        if (gm != null) {
                            sb.append("[");
                            sb.append(gm);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !com.baidu.tbadk.core.util.am.isEmpty(next.bwF())) {
                        sb.append("[").append(next.bwF()).append("]");
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
                this.date = com.baidu.tbadk.core.util.am.z(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.hbj = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aOQ = metaData;
                }
                if ((this.aOQ.getUserId() == null || this.aOQ.getUserId().length() <= 0 || this.aOQ.getUserId().equals("0")) && metaData2 != null) {
                    this.aOQ = metaData2;
                }
                this.hbd = TbRichTextView.a(context, subPostList.content, z);
                if (this.hbd != null) {
                    this.hbd.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.date = com.baidu.tbadk.core.util.am.z(this.time);
                this.fHb = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aOQ = metaData;
                }
                this.hbu = post.need_log.intValue() == 1;
                this.hbv = post.img_num_abtest.intValue() == 1;
                this.hbm = new ay();
                this.hbm.parserProtobuf(post.from_forum);
                if (this.aOQ.getUserId() == null || this.aOQ.getUserId().length() <= 0 || this.aOQ.getUserId().equals("0")) {
                    this.aOQ.parserProtobuf(post.author);
                }
                if (this.aOQ != null && context != null) {
                    this.hbq = this.aOQ.getUserName() + context.getResources().getString(d.j.somebodys_portrait);
                    this.hbr = String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(this.aOQ.getLevel_id()));
                }
                this.hbg = post.is_ntitle.intValue() == 1;
                this.haZ = post.sub_post_number.intValue();
                this.hbl = new h(post.tpoint_post);
                this.hbd = TbRichTextView.a(context, post.content, true);
                if (this.hbd != null) {
                    this.hbd.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.hbd.iT(this.floor_num);
                    if (this.aOQ != null) {
                        this.hbd.setAuthorId(this.aOQ.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.hbj = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.hba.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.hbf.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.hbh = new com.baidu.tbadk.data.c();
                    this.hbh.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.hbi = new com.baidu.tbadk.data.f();
                    this.hbi.a(post.lbs_info);
                }
                this.aPy = post.storecount.intValue();
                this.hbe.a(post.present);
                this.aPc.setUserMap(this.userMap);
                this.aPc.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.gaY = new SmallTailInfo();
                    this.gaY.id = post.signature.signature_id.intValue();
                    this.gaY.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.gaY.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.gaY.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.gaY.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.aPM.add(cVar);
                    }
                }
                this.aPO = post.skin_info;
                this.aPR = post.lego_card;
                this.hbs = post.tpoint_post;
                if (post.agree != null) {
                    this.hbt = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                } else {
                    this.hbt = false;
                }
                this.hbA = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.aQw = new OriginalThreadInfo();
                    this.aQw.parser(post.origin_thread_info);
                } else {
                    this.aQw = null;
                }
                this.hbD = post.is_fold.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int fZo;

        public CustomForegroundColorSpan(int i) {
            super(aj.getColor(i));
            this.fZo = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(this.fZo));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> hbK;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.hbK = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.C0140d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.hbK != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hbK.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String cl(Context context) {
        ArrayList<TbRichTextData> Ri;
        if (this.hbd == null || (Ri = this.hbd.Ri()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Ri.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Rp().toString());
            } else if (next.getType() == 17) {
                String str = next.Rt().mGifInfo.mSharpText;
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

    public String bxa() {
        ArrayList<TbRichTextData> Ri;
        String str;
        if (this.hbd == null || (Ri = this.hbd.Ri()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = Ri.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.Rp().toString());
                } else if (next.getType() == 17) {
                    if (next.Rt() != null && next.Rt().mGifInfo != null && (str = next.Rt().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo bxb() {
        ArrayList<TbRichTextData> Ri;
        if (this.hbd != null && (Ri = this.hbd.Ri()) != null) {
            Iterator<TbRichTextData> it = Ri.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.Ro().getWidth();
                    preLoadImageInfo.height = next.Ro().getHeight();
                    preLoadImageInfo.imgUrl = next.Ro().RC();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.Ru().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.Ru().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.Ru().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bxc() {
        j bwy;
        PreLoadImageInfo bxb = bxb();
        if (bxb != null && !StringUtils.isNull(bxb.imgUrl)) {
            return bxb.imgUrl;
        }
        if (this.hbl != null && (bwy = this.hbl.bwy()) != null && !StringUtils.isNull(bwy.bwD())) {
            return bwy.bwD();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Ri;
        if (this.hbd == null || (Ri = this.hbd.Ri()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Ri.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.Ro().getWidth();
                preLoadImageInfo.height = next.Ro().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.Ro().RH()) {
                    preLoadImageInfo.imgUrl = next.Ro().RD();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.Ro().RC();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.Rt() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.Rt().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.Rt().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.Rt();
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
        if (this.aOQ == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.aOQ.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.haW == 52) {
            return haT;
        }
        if (this.haW == 1) {
            return aPP;
        }
        if (this.haW == 36) {
            return haR;
        }
        if (this.haW == 40 || this.haW == 50) {
            return aOx;
        }
        if (this.haW == 41) {
            return haS;
        }
        if (this.haW == 53) {
            return haU;
        }
        if (bwU() == 1) {
            return haP;
        }
        return haQ;
    }

    public void setPostType(int i) {
        this.haW = i;
    }

    public am bxd() {
        return this.hbe;
    }

    public void a(am amVar) {
        this.hbe = amVar;
    }

    public h bxe() {
        return this.hbl;
    }

    public com.baidu.tbadk.widget.richText.f Rs() {
        if (this.hbp != null) {
            return this.hbp;
        }
        if (this.hbd != null && v.D(this.hbd.Ri()) > 0) {
            Iterator<TbRichTextData> it = this.hbd.Ri().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.hbp = next.Rs();
                    return this.hbp;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo Rq() {
        if (this.bel != null) {
            return this.bel;
        }
        if (this.hbd != null && v.D(this.hbd.Ri()) > 0) {
            Iterator<TbRichTextData> it = this.hbd.Ri().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.bel = next.Rq();
                    return this.bel;
                }
            }
        }
        return null;
    }

    public String bxf() {
        return this.hbq;
    }

    public String Af() {
        return this.aPR;
    }

    public void Ai() {
        if (this.aPo == 0) {
            this.aPo = 1;
        }
    }

    public long bxg() {
        return this.agreeNum;
    }

    public void cQ(long j) {
        this.agreeNum = j;
    }

    public boolean bxh() {
        return this.hasAgree;
    }

    public void mK(boolean z) {
        this.hasAgree = z;
    }

    public OriginalThreadInfo bxi() {
        return this.aQw;
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        this.aQw = originalThreadInfo;
    }

    public int bxj() {
        return this.hbD;
    }
}
