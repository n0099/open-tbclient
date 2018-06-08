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
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
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
public class PostData implements com.baidu.adp.widget.ListView.h, af {
    private OriginalThreadInfo ajP;
    private SkinInfo aji;
    private String ajl;
    @Deprecated
    private String authorId;
    private TbRichTextVoiceInfo axA;
    private String bimg_url;
    private SmallTailInfo fHJ;
    private String fok;
    public int gJB;
    public AlaLiveInfoCoreData gJG;
    private ArrayList<PostData> gJf;
    private com.baidu.tbadk.data.c gJm;
    private com.baidu.tbadk.data.f gJn;
    private h gJq;
    private az gJr;
    public boolean gJt;
    private com.baidu.tbadk.widget.richText.f gJu;
    private String gJv;
    private String gJw;
    private TPointPost gJx;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId gIU = BdUniqueId.gen();
    public static final BdUniqueId gIV = BdUniqueId.gen();
    public static final BdUniqueId ajj = BdUniqueId.gen();
    public static final BdUniqueId gIW = BdUniqueId.gen();
    public static final BdUniqueId ahM = BdUniqueId.gen();
    public static final BdUniqueId gIX = BdUniqueId.gen();
    public static final BdUniqueId gIY = BdUniqueId.gen();
    public static final BdUniqueId gIZ = BdUniqueId.gen();
    public static boolean gJa = false;
    private int gJb = 0;
    private boolean gJg = false;
    private ArrayList<PostData> gJh = null;
    private TbRichText gJi = null;
    private boolean gJl = false;
    private boolean gJo = false;
    private boolean gJp = false;
    public boolean gJs = false;
    public int aiI = 0;
    private boolean gJy = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean gJz = false;
    public boolean gJA = false;
    public boolean gJC = false;
    public boolean gJD = true;
    public boolean gJE = false;
    public boolean gJF = false;
    private boolean gJH = false;
    private int gJI = 0;
    private boolean gJJ = true;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData aik = new MetaData();
    private ArrayList<k> gJc = new ArrayList<>();
    private ArrayList<k> gJd = new ArrayList<>();
    private int gJe = 0;
    private int aiS = 0;
    private PraiseData aiw = new PraiseData();
    private an gJj = new an();
    private c gJk = new c();
    private ArrayList<com.baidu.tbadk.data.c> ajf = new ArrayList<>();

    public PostData() {
        this.gJf = null;
        this.gJB = 0;
        this.gJf = new ArrayList<>();
        this.gJB = 0;
    }

    public ArrayList<PostData> bwS() {
        return this.gJh;
    }

    public void bwT() {
        this.gJh.clear();
        this.gJh = null;
        this.gJg = false;
    }

    public void o(PostData postData) {
        if (postData != null) {
            if (this.gJh == null) {
                this.gJh = new ArrayList<>();
                if (w.y(this.gJf) > 2) {
                    this.gJh.addAll(w.a(this.gJf, 0, 2));
                } else {
                    this.gJh.addAll(this.gJf);
                }
            }
            this.gJh.add(postData);
        }
    }

    public void p(PostData postData) {
        if (postData != null && this.gJf != null) {
            this.gJf.add(postData);
            bwX();
        }
    }

    public void tN(String str) {
        if (this.gJh != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.gJh.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.gJh.remove(next);
                    return;
                }
            }
        }
    }

    public void mu(boolean z) {
        this.gJJ = z;
    }

    public boolean bwU() {
        return this.gJJ;
    }

    public void mv(boolean z) {
        this.gJg = z;
    }

    public boolean bwV() {
        return this.gJg;
    }

    public ArrayList<PostData> bwW() {
        return this.gJf;
    }

    public void bwX() {
        this.gJe++;
    }

    public void bwY() {
        this.gJe--;
    }

    public void ty(int i) {
        this.gJe = i;
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

    public String bah() {
        return this.fok;
    }

    public int bwZ() {
        return this.floor_num;
    }

    public void tz(int i) {
        this.floor_num = i;
    }

    public boolean bxa() {
        return this.gJp;
    }

    public void mw(boolean z) {
        this.gJp = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ao.v(j);
    }

    public MetaData vm() {
        return this.aik;
    }

    public void a(MetaData metaData) {
        this.aik = metaData;
    }

    public void a(PraiseData praiseData) {
        this.aiw = praiseData;
    }

    public TbRichText bxb() {
        return this.gJi;
    }

    public void c(TbRichText tbRichText) {
        this.gJi = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bgZ() {
        return this.fHJ;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.fHJ = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bxc() {
        return this.gJn;
    }

    public SkinInfo vG() {
        return this.aji;
    }

    public void mx(boolean z) {
        this.gJH = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.gJi != null && this.gJi.Ng() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else if (this.aik != null && this.aik.getIs_bawu() == 1 && "manager".equals(this.aik.getBawu_type())) {
                str = " 吧主";
            } else if (this.aik == null || this.aik.getIs_bawu() != 1 || !"assist".equals(this.aik.getBawu_type())) {
                str = "";
            } else {
                str = " 小吧";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = vm().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.ig().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.ig().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((C02351) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.na()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.gJi.isChanged = true;
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
            if (!StringUtils.isNull(this.aik.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.aik.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.aik == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.aik.getName_show() + str + "：");
                str2 = this.aik.getUserName();
                str3 = this.aik.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.aik.getSealPrefix())) {
                Bitmap cQ = al.cQ(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
                if (cQ != null) {
                    bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.e(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.aik.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.aik != null && this.aik.getIs_bawu() == 1))) {
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.C0141d.cp_link_tip_a);
                if (this.aik != null) {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.aik.getName_show().length() + 1, str.length() + sb2.length() + this.aik.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> Ng = this.gJi.Ng();
            if (Ng != null && Ng.size() > 0) {
                TbRichTextData tbRichTextData2 = Ng.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.Nn() != null) {
                    if (this.gJH) {
                        int indexOf = tbRichTextData2.Nn().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.Nn().delete(0, indexOf + 1);
                        }
                        this.gJH = false;
                    }
                    tbRichTextData2.fW(sb.length());
                    tbRichTextData2.Nn().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Ng.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (Ng.get(i4) == null || Ng.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo No = Ng.get(i4).No();
                        Ng.remove(i4);
                        tbRichTextVoiceInfo = No;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fW(sb.length());
                tbRichTextData.append(spannableString);
                Ng.add(0, tbRichTextData);
            }
        }
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap mZ;
        if (aVar == null || (mZ = aVar.mZ()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mZ);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36));
        return bitmapDrawable;
    }

    public int bxd() {
        return this.gJe;
    }

    public void ci(Context context) {
        int type;
        int i;
        int i2;
        if (this.gJc != null) {
            int i3 = -1;
            int size = this.gJd.size();
            if (size > 0) {
                try {
                    i3 = this.gJd.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.gJc.size()) {
                k kVar = this.gJc.get(i4);
                if (k.bK(i5, kVar.getType())) {
                    this.gJd.get(size - 1).b(kVar.ch(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.gJd.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.ch(context));
                        this.gJd.add(kVar2);
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

    public void cj(Context context) {
        try {
            if (this.gJi != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.gJi.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.gJd == null || this.gJd.size() == 0) {
                ci(context);
            }
            ArrayList<k> arrayList = this.gJd;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bwM() != null) {
                            sb.append((CharSequence) next.bwM());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.k.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.k.voice_str));
                    } else if (next.getType() == 2) {
                        String gC = TbFaceManager.IC().gC(next.getText());
                        if (gC != null) {
                            sb.append("[");
                            sb.append(gC);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ao.isEmpty(next.bwL())) {
                        sb.append("[").append(next.bwL()).append("]");
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
                this.date = ao.v(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.gJo = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aik = metaData;
                }
                if ((this.aik.getUserId() == null || this.aik.getUserId().length() <= 0 || this.aik.getUserId().equals("0")) && metaData2 != null) {
                    this.aik = metaData2;
                }
                this.gJi = TbRichTextView.a(context, subPostList.content, z);
                if (this.gJi != null) {
                    this.gJi.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.date = ao.v(this.time);
                this.fok = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aik = metaData;
                }
                this.gJz = post.need_log.intValue() == 1;
                this.gJA = post.img_num_abtest.intValue() == 1;
                this.gJr = new az();
                this.gJr.parserProtobuf(post.from_forum);
                if (this.aik.getUserId() == null || this.aik.getUserId().length() <= 0 || this.aik.getUserId().equals("0")) {
                    this.aik.parserProtobuf(post.author);
                }
                if (this.aik != null && context != null) {
                    this.gJv = this.aik.getUserName() + context.getResources().getString(d.k.somebodys_portrait);
                    this.gJw = String.format(TbadkCoreApplication.getInst().getString(d.k.degree_in_forum), Integer.valueOf(this.aik.getLevel_id()));
                }
                this.gJl = post.is_ntitle.intValue() == 1;
                this.gJe = post.sub_post_number.intValue();
                this.gJq = new h(post.tpoint_post);
                this.gJi = TbRichTextView.a(context, post.content, true);
                if (this.gJi != null) {
                    this.gJi.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.gJi.fV(this.floor_num);
                    if (this.aik != null) {
                        this.gJi.setAuthorId(this.aik.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.gJo = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.gJf.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.gJk.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.gJm = new com.baidu.tbadk.data.c();
                    this.gJm.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.gJn = new com.baidu.tbadk.data.f();
                    this.gJn.a(post.lbs_info);
                }
                this.aiS = post.storecount.intValue();
                this.gJj.a(post.present);
                this.aiw.setUserMap(this.userMap);
                this.aiw.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.fHJ = new SmallTailInfo();
                    this.fHJ.id = post.signature.signature_id.intValue();
                    this.fHJ.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.fHJ.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.fHJ.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.fHJ.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.ajf.add(cVar);
                    }
                }
                this.aji = post.skin_info;
                this.ajl = post.lego_card;
                this.gJx = post.tpoint_post;
                if (post.agree != null) {
                    this.gJy = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                } else {
                    this.gJy = false;
                }
                this.gJF = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.ajP = new OriginalThreadInfo();
                    this.ajP.parser(post.origin_thread_info);
                } else {
                    this.ajP = null;
                }
                this.gJI = post.is_fold.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int fFU;

        public CustomForegroundColorSpan(int i) {
            super(al.getColor(i));
            this.fFU = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(this.fFU));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> gJP;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.gJP = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(d.C0141d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.gJP != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.gJP.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String ck(Context context) {
        ArrayList<TbRichTextData> Ng;
        if (this.gJi == null || (Ng = this.gJi.Ng()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Ng.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Nn().toString());
            } else if (next.getType() == 17) {
                String str = next.Nr().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(d.k.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(d.k.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(d.k.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String bxe() {
        ArrayList<TbRichTextData> Ng;
        String str;
        if (this.gJi == null || (Ng = this.gJi.Ng()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = Ng.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.Nn().toString());
                } else if (next.getType() == 17) {
                    if (next.Nr() != null && next.Nr().mGifInfo != null && (str = next.Nr().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
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
        ArrayList<TbRichTextData> Ng;
        if (this.gJi != null && (Ng = this.gJi.Ng()) != null) {
            Iterator<TbRichTextData> it = Ng.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.Nm().getWidth();
                    preLoadImageInfo.height = next.Nm().getHeight();
                    preLoadImageInfo.imgUrl = next.Nm().Nz();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.Ns().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.Ns().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.Ns().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bxg() {
        j bwE;
        PreLoadImageInfo bxf = bxf();
        if (bxf != null && !StringUtils.isNull(bxf.imgUrl)) {
            return bxf.imgUrl;
        }
        if (this.gJq != null && (bwE = this.gJq.bwE()) != null && !StringUtils.isNull(bwE.bwJ())) {
            return bwE.bwJ();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.af
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Ng;
        if (this.gJi == null || (Ng = this.gJi.Ng()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Ng.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.Nm().getWidth();
                preLoadImageInfo.height = next.Nm().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.Nm().NE()) {
                    preLoadImageInfo.imgUrl = next.Nm().NA();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.Nm().Nz();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.Nr() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.Nr().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.Nr().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.Nr();
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
        if (this.aik == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.aik.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.gJb == 52) {
            return gIY;
        }
        if (this.gJb == 1) {
            return ajj;
        }
        if (this.gJb == 36) {
            return gIW;
        }
        if (this.gJb == 40 || this.gJb == 50) {
            return ahM;
        }
        if (this.gJb == 41) {
            return gIX;
        }
        if (this.gJb == 53) {
            return gIZ;
        }
        if (bwZ() == 1) {
            return gIU;
        }
        return gIV;
    }

    public void setPostType(int i) {
        this.gJb = i;
    }

    public an bxh() {
        return this.gJj;
    }

    public void a(an anVar) {
        this.gJj = anVar;
    }

    public h bxi() {
        return this.gJq;
    }

    public com.baidu.tbadk.widget.richText.f Nq() {
        if (this.gJu != null) {
            return this.gJu;
        }
        if (this.gJi != null && w.y(this.gJi.Ng()) > 0) {
            Iterator<TbRichTextData> it = this.gJi.Ng().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.gJu = next.Nq();
                    return this.gJu;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo No() {
        if (this.axA != null) {
            return this.axA;
        }
        if (this.gJi != null && w.y(this.gJi.Ng()) > 0) {
            Iterator<TbRichTextData> it = this.gJi.Ng().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.axA = next.No();
                    return this.axA;
                }
            }
        }
        return null;
    }

    public String bxj() {
        return this.gJv;
    }

    public String wd() {
        return this.ajl;
    }

    public void wg() {
        if (this.aiI == 0) {
            this.aiI = 1;
        }
    }

    public long bxk() {
        return this.agreeNum;
    }

    public void da(long j) {
        this.agreeNum = j;
    }

    public boolean bxl() {
        return this.hasAgree;
    }

    public void my(boolean z) {
        this.hasAgree = z;
    }

    public OriginalThreadInfo bxm() {
        return this.ajP;
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        this.ajP = originalThreadInfo;
    }

    public int bxn() {
        return this.gJI;
    }
}
