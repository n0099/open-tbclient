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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ak;
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
public class PostData implements com.baidu.adp.widget.ListView.h, ae {
    private OriginalThreadInfo abM;
    private SkinInfo abe;
    private String abh;
    private TbRichTextVoiceInfo apt;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String fcP;
    private SmallTailInfo fwp;
    private ArrayList<PostData> gxG;
    private com.baidu.tbadk.data.c gxN;
    private com.baidu.tbadk.data.f gxO;
    private h gxR;
    private az gxS;
    public boolean gxU;
    private com.baidu.tbadk.widget.richText.f gxV;
    private String gxW;
    private String gxX;
    private TPointPost gxY;
    public int gyc;
    public AlaLiveInfoCoreData gyh;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId gxv = BdUniqueId.gen();
    public static final BdUniqueId gxw = BdUniqueId.gen();
    public static final BdUniqueId abf = BdUniqueId.gen();
    public static final BdUniqueId gxx = BdUniqueId.gen();
    public static final BdUniqueId ZK = BdUniqueId.gen();
    public static final BdUniqueId gxy = BdUniqueId.gen();
    public static final BdUniqueId gxz = BdUniqueId.gen();
    public static final BdUniqueId gxA = BdUniqueId.gen();
    public static boolean gxB = false;
    private int gxC = 0;
    private boolean gxH = false;
    private ArrayList<PostData> gxI = null;
    private TbRichText gxJ = null;
    private boolean gxM = false;
    private boolean gxP = false;
    private boolean gxQ = false;
    public boolean gxT = false;
    public int aaD = 0;
    private boolean gxZ = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean gya = false;
    public boolean gyb = false;
    public boolean gyd = false;
    public boolean gye = true;
    public boolean gyf = false;
    public boolean gyg = false;
    private boolean gyi = false;
    private int gyj = 0;
    private boolean gyk = true;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData aaf = new MetaData();
    private ArrayList<k> gxD = new ArrayList<>();
    private ArrayList<k> gxE = new ArrayList<>();
    private int gxF = 0;
    private int aaN = 0;
    private PraiseData aar = new PraiseData();
    private an gxK = new an();
    private c gxL = new c();
    private ArrayList<com.baidu.tbadk.data.c> aba = new ArrayList<>();

    public PostData() {
        this.gxG = null;
        this.gyc = 0;
        this.gxG = new ArrayList<>();
        this.gyc = 0;
    }

    public ArrayList<PostData> brQ() {
        return this.gxI;
    }

    public void brR() {
        this.gxI.clear();
        this.gxI = null;
        this.gxH = false;
    }

    public void o(PostData postData) {
        if (postData != null) {
            if (this.gxI == null) {
                this.gxI = new ArrayList<>();
                if (v.v(this.gxG) > 2) {
                    this.gxI.addAll(v.a(this.gxG, 0, 2));
                } else {
                    this.gxI.addAll(this.gxG);
                }
            }
            this.gxI.add(postData);
        }
    }

    public void p(PostData postData) {
        if (postData != null && this.gxG != null) {
            this.gxG.add(postData);
            brV();
        }
    }

    public void sW(String str) {
        if (this.gxI != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.gxI.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.gxI.remove(next);
                    return;
                }
            }
        }
    }

    public void mo(boolean z) {
        this.gyk = z;
    }

    public boolean brS() {
        return this.gyk;
    }

    public void mp(boolean z) {
        this.gxH = z;
    }

    public boolean brT() {
        return this.gxH;
    }

    public ArrayList<PostData> brU() {
        return this.gxG;
    }

    public void brV() {
        this.gxF++;
    }

    public void brW() {
        this.gxF--;
    }

    public void tm(int i) {
        this.gxF = i;
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

    public String aVl() {
        return this.fcP;
    }

    public int brX() {
        return this.floor_num;
    }

    public void tn(int i) {
        this.floor_num = i;
    }

    public boolean brY() {
        return this.gxQ;
    }

    public void mq(boolean z) {
        this.gxQ = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = com.baidu.tbadk.core.util.an.s(j);
    }

    public MetaData rP() {
        return this.aaf;
    }

    public void a(MetaData metaData) {
        this.aaf = metaData;
    }

    public void a(PraiseData praiseData) {
        this.aar = praiseData;
    }

    public TbRichText brZ() {
        return this.gxJ;
    }

    public void c(TbRichText tbRichText) {
        this.gxJ = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bbZ() {
        return this.fwp;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.fwp = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bsa() {
        return this.gxO;
    }

    public SkinInfo sj() {
        return this.abe;
    }

    public void mr(boolean z) {
        this.gyi = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.gxJ != null && this.gxJ.JH() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else if (this.aaf != null && this.aaf.getIs_bawu() == 1 && "manager".equals(this.aaf.getBawu_type())) {
                str = " 吧主";
            } else if (this.aaf == null || this.aaf.getIs_bawu() != 1 || !"assist".equals(this.aaf.getBawu_type())) {
                str = "";
            } else {
                str = " 小吧";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = rP().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.fp().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.fp().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((C02181) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.km()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.gxJ.isChanged = true;
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
            if (!StringUtils.isNull(this.aaf.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.aaf.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.aaf == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.aaf.getName_show() + str + "：");
                str2 = this.aaf.getUserName();
                str3 = this.aaf.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.aaf.getSealPrefix())) {
                Bitmap cO = ak.cO(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
                if (cO != null) {
                    bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
                }
                com.baidu.tbadk.core.view.h hVar = new com.baidu.tbadk.core.view.h(bitmapDrawable);
                hVar.setOffset(com.baidu.adp.lib.util.l.e(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.aaf.getSealPrefix().length() + 1;
                spannableString.setSpan(hVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.aaf != null && this.aaf.getIs_bawu() == 1))) {
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.C0126d.cp_link_tip_a);
                if (this.aaf != null) {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.aaf.getName_show().length() + 1, str.length() + sb2.length() + this.aaf.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> JH = this.gxJ.JH();
            if (JH != null && JH.size() > 0) {
                TbRichTextData tbRichTextData2 = JH.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.JO() != null) {
                    if (this.gyi) {
                        int indexOf = tbRichTextData2.JO().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.JO().delete(0, indexOf + 1);
                        }
                        this.gyi = false;
                    }
                    tbRichTextData2.fV(sb.length());
                    tbRichTextData2.JO().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= JH.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (JH.get(i4) == null || JH.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo JP = JH.get(i4).JP();
                        JH.remove(i4);
                        tbRichTextVoiceInfo = JP;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fV(sb.length());
                tbRichTextData.append(spannableString);
                JH.add(0, tbRichTextData);
            }
        }
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap kl;
        if (aVar == null || (kl = aVar.kl()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kl);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36));
        return bitmapDrawable;
    }

    public int bsb() {
        return this.gxF;
    }

    public void bX(Context context) {
        int type;
        int i;
        int i2;
        if (this.gxD != null) {
            int i3 = -1;
            int size = this.gxE.size();
            if (size > 0) {
                try {
                    i3 = this.gxE.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.gxD.size()) {
                k kVar = this.gxD.get(i4);
                if (k.bI(i5, kVar.getType())) {
                    this.gxE.get(size - 1).b(kVar.bW(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.gxE.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.bW(context));
                        this.gxE.add(kVar2);
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

    public void bY(Context context) {
        try {
            if (this.gxJ != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.gxJ.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.gxE == null || this.gxE.size() == 0) {
                bX(context);
            }
            ArrayList<k> arrayList = this.gxE;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.brK() != null) {
                            sb.append((CharSequence) next.brK());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.k.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.k.voice_str));
                    } else if (next.getType() == 2) {
                        String gd = TbFaceManager.EX().gd(next.getText());
                        if (gd != null) {
                            sb.append("[");
                            sb.append(gd);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !com.baidu.tbadk.core.util.an.isEmpty(next.brJ())) {
                        sb.append("[").append(next.brJ()).append("]");
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
                this.date = com.baidu.tbadk.core.util.an.s(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.gxP = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aaf = metaData;
                }
                if ((this.aaf.getUserId() == null || this.aaf.getUserId().length() <= 0 || this.aaf.getUserId().equals("0")) && metaData2 != null) {
                    this.aaf = metaData2;
                }
                this.gxJ = TbRichTextView.a(context, subPostList.content, z);
                if (this.gxJ != null) {
                    this.gxJ.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.date = com.baidu.tbadk.core.util.an.s(this.time);
                this.fcP = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aaf = metaData;
                }
                this.gya = post.need_log.intValue() == 1;
                this.gyb = post.img_num_abtest.intValue() == 1;
                this.gxS = new az();
                this.gxS.parserProtobuf(post.from_forum);
                if (this.aaf.getUserId() == null || this.aaf.getUserId().length() <= 0 || this.aaf.getUserId().equals("0")) {
                    this.aaf.parserProtobuf(post.author);
                }
                if (this.aaf != null && context != null) {
                    this.gxW = this.aaf.getUserName() + context.getResources().getString(d.k.somebodys_portrait);
                    this.gxX = String.format(TbadkCoreApplication.getInst().getString(d.k.degree_in_forum), Integer.valueOf(this.aaf.getLevel_id()));
                }
                this.gxM = post.is_ntitle.intValue() == 1;
                this.gxF = post.sub_post_number.intValue();
                this.gxR = new h(post.tpoint_post);
                this.gxJ = TbRichTextView.a(context, post.content, true);
                if (this.gxJ != null) {
                    this.gxJ.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.gxJ.fU(this.floor_num);
                    if (this.aaf != null) {
                        this.gxJ.setAuthorId(this.aaf.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.gxP = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.gxG.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.gxL.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.gxN = new com.baidu.tbadk.data.c();
                    this.gxN.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.gxO = new com.baidu.tbadk.data.f();
                    this.gxO.a(post.lbs_info);
                }
                this.aaN = post.storecount.intValue();
                this.gxK.a(post.present);
                this.aar.setUserMap(this.userMap);
                this.aar.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.fwp = new SmallTailInfo();
                    this.fwp.id = post.signature.signature_id.intValue();
                    this.fwp.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.fwp.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.fwp.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.fwp.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.aba.add(cVar);
                    }
                }
                this.abe = post.skin_info;
                this.abh = post.lego_card;
                this.gxY = post.tpoint_post;
                if (post.agree != null) {
                    this.gxZ = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                } else {
                    this.gxZ = false;
                }
                this.gyg = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.abM = new OriginalThreadInfo();
                    this.abM.parser(post.origin_thread_info);
                } else {
                    this.abM = null;
                }
                this.gyj = post.is_fold.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int fuD;

        public CustomForegroundColorSpan(int i) {
            super(ak.getColor(i));
            this.fuD = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ak.getColor(this.fuD));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> gyq;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.gyq = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ak.getColor(d.C0126d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            if (this.mName != null && this.mId != null && this.gyq != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.gyq.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bZ(Context context) {
        ArrayList<TbRichTextData> JH;
        if (this.gxJ == null || (JH = this.gxJ.JH()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = JH.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.JO().toString());
            } else if (next.getType() == 17) {
                String str = next.JS().mGifInfo.mSharpText;
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

    public String bsc() {
        ArrayList<TbRichTextData> JH;
        String str;
        if (this.gxJ == null || (JH = this.gxJ.JH()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = JH.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.JO().toString());
                } else if (next.getType() == 17) {
                    if (next.JS() != null && next.JS().mGifInfo != null && (str = next.JS().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo bsd() {
        ArrayList<TbRichTextData> JH;
        if (this.gxJ != null && (JH = this.gxJ.JH()) != null) {
            Iterator<TbRichTextData> it = JH.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.JN().getWidth();
                    preLoadImageInfo.height = next.JN().getHeight();
                    preLoadImageInfo.imgUrl = next.JN().Ka();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.JT().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.JT().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.JT().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bse() {
        j brC;
        PreLoadImageInfo bsd = bsd();
        if (bsd != null && !StringUtils.isNull(bsd.imgUrl)) {
            return bsd.imgUrl;
        }
        if (this.gxR != null && (brC = this.gxR.brC()) != null && !StringUtils.isNull(brC.brH())) {
            return brC.brH();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> JH;
        if (this.gxJ == null || (JH = this.gxJ.JH()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = JH.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.JN().getWidth();
                preLoadImageInfo.height = next.JN().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.JN().Kf()) {
                    preLoadImageInfo.imgUrl = next.JN().Kb();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.JN().Ka();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.JS() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.JS().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.JS().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.JS();
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
        if (this.aaf == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.aaf.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.gxC == 52) {
            return gxz;
        }
        if (this.gxC == 1) {
            return abf;
        }
        if (this.gxC == 36) {
            return gxx;
        }
        if (this.gxC == 40 || this.gxC == 50) {
            return ZK;
        }
        if (this.gxC == 41) {
            return gxy;
        }
        if (this.gxC == 53) {
            return gxA;
        }
        if (brX() == 1) {
            return gxv;
        }
        return gxw;
    }

    public void setPostType(int i) {
        this.gxC = i;
    }

    public an bsf() {
        return this.gxK;
    }

    public void a(an anVar) {
        this.gxK = anVar;
    }

    public h bsg() {
        return this.gxR;
    }

    public com.baidu.tbadk.widget.richText.f JR() {
        if (this.gxV != null) {
            return this.gxV;
        }
        if (this.gxJ != null && v.v(this.gxJ.JH()) > 0) {
            Iterator<TbRichTextData> it = this.gxJ.JH().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.gxV = next.JR();
                    return this.gxV;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo JP() {
        if (this.apt != null) {
            return this.apt;
        }
        if (this.gxJ != null && v.v(this.gxJ.JH()) > 0) {
            Iterator<TbRichTextData> it = this.gxJ.JH().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.apt = next.JP();
                    return this.apt;
                }
            }
        }
        return null;
    }

    public String bsh() {
        return this.gxW;
    }

    public String sG() {
        return this.abh;
    }

    public void sJ() {
        if (this.aaD == 0) {
            this.aaD = 1;
        }
    }

    public long bsi() {
        return this.agreeNum;
    }

    public void cU(long j) {
        this.agreeNum = j;
    }

    public boolean bsj() {
        return this.hasAgree;
    }

    public void ms(boolean z) {
        this.hasAgree = z;
    }

    public OriginalThreadInfo bsk() {
        return this.abM;
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        this.abM = originalThreadInfo;
    }

    public int bsl() {
        return this.gyj;
    }
}
