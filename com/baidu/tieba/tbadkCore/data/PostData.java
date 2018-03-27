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
    private SkinInfo aPE;
    private String aPH;
    private OriginalThreadInfo aQm;
    @Deprecated
    private String authorId;
    private TbRichTextVoiceInfo bec;
    private String bimg_url;
    private String fHg;
    private SmallTailInfo gbd;
    private String hbA;
    private TPointPost hbB;
    public int hbF;
    public AlaLiveInfoCoreData hbK;
    private ArrayList<PostData> hbj;
    private com.baidu.tbadk.data.c hbq;
    private com.baidu.tbadk.data.f hbr;
    private h hbu;
    private ay hbv;
    public boolean hbx;
    private com.baidu.tbadk.widget.richText.f hby;
    private String hbz;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId haY = BdUniqueId.gen();
    public static final BdUniqueId haZ = BdUniqueId.gen();
    public static final BdUniqueId aPF = BdUniqueId.gen();
    public static final BdUniqueId hba = BdUniqueId.gen();
    public static final BdUniqueId aOn = BdUniqueId.gen();
    public static final BdUniqueId hbb = BdUniqueId.gen();
    public static final BdUniqueId hbc = BdUniqueId.gen();
    public static final BdUniqueId hbd = BdUniqueId.gen();
    public static boolean hbe = false;
    private int hbf = 0;
    private boolean hbk = false;
    private ArrayList<PostData> hbl = null;
    private TbRichText hbm = null;
    private boolean hbp = false;
    private boolean hbs = false;
    private boolean hbt = false;
    public boolean hbw = false;
    public int aPe = 0;
    private boolean hbC = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean hbD = false;
    public boolean hbE = false;
    public boolean hbG = false;
    public boolean hbH = true;
    public boolean hbI = false;
    public boolean hbJ = false;
    private boolean hbL = false;
    private int hbM = 0;
    private boolean hbN = true;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData aOG = new MetaData();
    private ArrayList<k> hbg = new ArrayList<>();
    private ArrayList<k> hbh = new ArrayList<>();
    private int hbi = 0;
    private int aPo = 0;
    private PraiseData aOS = new PraiseData();
    private am hbn = new am();
    private c hbo = new c();
    private ArrayList<com.baidu.tbadk.data.c> aPC = new ArrayList<>();

    public PostData() {
        this.hbj = null;
        this.hbF = 0;
        this.hbj = new ArrayList<>();
        this.hbF = 0;
    }

    public ArrayList<PostData> bwR() {
        return this.hbl;
    }

    public void bwS() {
        this.hbl.clear();
        this.hbl = null;
        this.hbk = false;
    }

    public void p(PostData postData) {
        if (postData != null) {
            if (this.hbl == null) {
                this.hbl = new ArrayList<>();
                if (v.D(this.hbj) > 2) {
                    this.hbl.addAll(v.b(this.hbj, 0, 2));
                } else {
                    this.hbl.addAll(this.hbj);
                }
            }
            this.hbl.add(postData);
        }
    }

    public void q(PostData postData) {
        if (postData != null && this.hbj != null) {
            this.hbj.add(postData);
            bwW();
        }
    }

    public void sM(String str) {
        if (this.hbl != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.hbl.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.hbl.remove(next);
                    return;
                }
            }
        }
    }

    public void mL(boolean z) {
        this.hbN = z;
    }

    public boolean bwT() {
        return this.hbN;
    }

    public void mM(boolean z) {
        this.hbk = z;
    }

    public boolean bwU() {
        return this.hbk;
    }

    public ArrayList<PostData> bwV() {
        return this.hbj;
    }

    public void bwW() {
        this.hbi++;
    }

    public void bwX() {
        this.hbi--;
    }

    public void vL(int i) {
        this.hbi = i;
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
        return this.fHg;
    }

    public int bwY() {
        return this.floor_num;
    }

    public void vM(int i) {
        this.floor_num = i;
    }

    public boolean bwZ() {
        return this.hbt;
    }

    public void mN(boolean z) {
        this.hbt = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = com.baidu.tbadk.core.util.am.z(j);
    }

    public String bxa() {
        return this.date;
    }

    public MetaData zn() {
        return this.aOG;
    }

    public void a(MetaData metaData) {
        this.aOG = metaData;
    }

    public void a(PraiseData praiseData) {
        this.aOS = praiseData;
    }

    public TbRichText bxb() {
        return this.hbm;
    }

    public void c(TbRichText tbRichText) {
        this.hbm = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bha() {
        return this.gbd;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.gbd = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bxc() {
        return this.hbr;
    }

    public SkinInfo zJ() {
        return this.aPE;
    }

    public void mO(boolean z) {
        this.hbL = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.hbm != null && this.hbm.Ri() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else if (this.aOG != null && this.aOG.getIs_bawu() == 1 && "manager".equals(this.aOG.getBawu_type())) {
                str = " 吧主";
            } else if (this.aOG == null || this.aOG.getIs_bawu() != 1 || !"assist".equals(this.aOG.getBawu_type())) {
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
                                        super.onLoaded((C02371) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.si()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.hbm.isChanged = true;
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
            if (!StringUtils.isNull(this.aOG.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.aOG.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.aOG == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.aOG.getName_show() + str + "：");
                str2 = this.aOG.getUserName();
                str3 = this.aOG.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.aOG.getSealPrefix())) {
                Bitmap fO = aj.fO(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(fO);
                if (fO != null) {
                    bitmapDrawable.setBounds(0, 0, fO.getWidth(), fO.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.t(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.aOG.getSealPrefix().length() + 1;
                spannableString.setSpan(mVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.aOG != null && this.aOG.getIs_bawu() == 1))) {
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.C0141d.cp_link_tip_a);
                if (this.aOG != null) {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.aOG.getName_show().length() + 1, str.length() + sb2.length() + this.aOG.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> Ri = this.hbm.Ri();
            if (Ri != null && Ri.size() > 0) {
                TbRichTextData tbRichTextData2 = Ri.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.Rp() != null) {
                    if (this.hbL) {
                        int indexOf = tbRichTextData2.Rp().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.Rp().delete(0, indexOf + 1);
                        }
                        this.hbL = false;
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

    public int bxd() {
        return this.hbi;
    }

    public void cj(Context context) {
        int type;
        int i;
        int i2;
        if (this.hbg != null) {
            int i3 = -1;
            int size = this.hbh.size();
            if (size > 0) {
                try {
                    i3 = this.hbh.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.hbg.size()) {
                k kVar = this.hbg.get(i4);
                if (k.cH(i5, kVar.getType())) {
                    this.hbh.get(size - 1).b(kVar.ci(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.hbh.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.ci(context));
                        this.hbh.add(kVar2);
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
            if (this.hbm != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.hbm.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.hbh == null || this.hbh.size() == 0) {
                cj(context);
            }
            ArrayList<k> arrayList = this.hbh;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bwK() != null) {
                            sb.append((CharSequence) next.bwK());
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
                    } else if (next.getType() == 11 && !com.baidu.tbadk.core.util.am.isEmpty(next.bwJ())) {
                        sb.append("[").append(next.bwJ()).append("]");
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
                this.hbs = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aOG = metaData;
                }
                if ((this.aOG.getUserId() == null || this.aOG.getUserId().length() <= 0 || this.aOG.getUserId().equals("0")) && metaData2 != null) {
                    this.aOG = metaData2;
                }
                this.hbm = TbRichTextView.a(context, subPostList.content, z);
                if (this.hbm != null) {
                    this.hbm.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.fHg = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aOG = metaData;
                }
                this.hbD = post.need_log.intValue() == 1;
                this.hbE = post.img_num_abtest.intValue() == 1;
                this.hbv = new ay();
                this.hbv.parserProtobuf(post.from_forum);
                if (this.aOG.getUserId() == null || this.aOG.getUserId().length() <= 0 || this.aOG.getUserId().equals("0")) {
                    this.aOG.parserProtobuf(post.author);
                }
                if (this.aOG != null && context != null) {
                    this.hbz = this.aOG.getUserName() + context.getResources().getString(d.j.somebodys_portrait);
                    this.hbA = String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(this.aOG.getLevel_id()));
                }
                this.hbp = post.is_ntitle.intValue() == 1;
                this.hbi = post.sub_post_number.intValue();
                this.hbu = new h(post.tpoint_post);
                this.hbm = TbRichTextView.a(context, post.content, true);
                if (this.hbm != null) {
                    this.hbm.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.hbm.iT(this.floor_num);
                    if (this.aOG != null) {
                        this.hbm.setAuthorId(this.aOG.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.hbs = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.hbj.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.hbo.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.hbq = new com.baidu.tbadk.data.c();
                    this.hbq.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.hbr = new com.baidu.tbadk.data.f();
                    this.hbr.a(post.lbs_info);
                }
                this.aPo = post.storecount.intValue();
                this.hbn.a(post.present);
                this.aOS.setUserMap(this.userMap);
                this.aOS.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.gbd = new SmallTailInfo();
                    this.gbd.id = post.signature.signature_id.intValue();
                    this.gbd.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.gbd.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.gbd.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.gbd.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.aPC.add(cVar);
                    }
                }
                this.aPE = post.skin_info;
                this.aPH = post.lego_card;
                this.hbB = post.tpoint_post;
                if (post.agree != null) {
                    this.hbC = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                } else {
                    this.hbC = false;
                }
                this.hbJ = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.aQm = new OriginalThreadInfo();
                    this.aQm.parser(post.origin_thread_info);
                } else {
                    this.aQm = null;
                }
                this.hbM = post.is_fold.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int fZt;

        public CustomForegroundColorSpan(int i) {
            super(aj.getColor(i));
            this.fZt = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(this.fZt));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> hbT;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.hbT = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.C0141d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.hbT != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hbT.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String cl(Context context) {
        ArrayList<TbRichTextData> Ri;
        if (this.hbm == null || (Ri = this.hbm.Ri()) == null) {
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

    public String bxe() {
        ArrayList<TbRichTextData> Ri;
        String str;
        if (this.hbm == null || (Ri = this.hbm.Ri()) == null) {
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

    public PreLoadImageInfo bxf() {
        ArrayList<TbRichTextData> Ri;
        if (this.hbm != null && (Ri = this.hbm.Ri()) != null) {
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

    public String bxg() {
        j bwC;
        PreLoadImageInfo bxf = bxf();
        if (bxf != null && !StringUtils.isNull(bxf.imgUrl)) {
            return bxf.imgUrl;
        }
        if (this.hbu != null && (bwC = this.hbu.bwC()) != null && !StringUtils.isNull(bwC.bwH())) {
            return bwC.bwH();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Ri;
        if (this.hbm == null || (Ri = this.hbm.Ri()) == null) {
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
        if (this.aOG == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.aOG.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.hbf == 52) {
            return hbc;
        }
        if (this.hbf == 1) {
            return aPF;
        }
        if (this.hbf == 36) {
            return hba;
        }
        if (this.hbf == 40 || this.hbf == 50) {
            return aOn;
        }
        if (this.hbf == 41) {
            return hbb;
        }
        if (this.hbf == 53) {
            return hbd;
        }
        if (bwY() == 1) {
            return haY;
        }
        return haZ;
    }

    public void setPostType(int i) {
        this.hbf = i;
    }

    public am bxh() {
        return this.hbn;
    }

    public void a(am amVar) {
        this.hbn = amVar;
    }

    public h bxi() {
        return this.hbu;
    }

    public com.baidu.tbadk.widget.richText.f Rs() {
        if (this.hby != null) {
            return this.hby;
        }
        if (this.hbm != null && v.D(this.hbm.Ri()) > 0) {
            Iterator<TbRichTextData> it = this.hbm.Ri().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.hby = next.Rs();
                    return this.hby;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo Rq() {
        if (this.bec != null) {
            return this.bec;
        }
        if (this.hbm != null && v.D(this.hbm.Ri()) > 0) {
            Iterator<TbRichTextData> it = this.hbm.Ri().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.bec = next.Rq();
                    return this.bec;
                }
            }
        }
        return null;
    }

    public String bxj() {
        return this.hbz;
    }

    public String Af() {
        return this.aPH;
    }

    public void Ai() {
        if (this.aPe == 0) {
            this.aPe = 1;
        }
    }

    public long bxk() {
        return this.agreeNum;
    }

    public void cQ(long j) {
        this.agreeNum = j;
    }

    public boolean bxl() {
        return this.hasAgree;
    }

    public void mP(boolean z) {
        this.hasAgree = z;
    }

    public OriginalThreadInfo bxm() {
        return this.aQm;
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        this.aQm = originalThreadInfo;
    }

    public int bxn() {
        return this.hbM;
    }
}
