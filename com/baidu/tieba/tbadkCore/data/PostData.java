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
    private OriginalThreadInfo abL;
    private SkinInfo abd;
    private String abg;
    private TbRichTextVoiceInfo apt;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String fbL;
    private SmallTailInfo fvm;
    private ArrayList<PostData> gwF;
    private com.baidu.tbadk.data.c gwM;
    private com.baidu.tbadk.data.f gwN;
    private h gwQ;
    private az gwR;
    public boolean gwT;
    private com.baidu.tbadk.widget.richText.f gwU;
    private String gwV;
    private String gwW;
    private TPointPost gwX;
    public int gxb;
    public AlaLiveInfoCoreData gxg;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId gwu = BdUniqueId.gen();
    public static final BdUniqueId gwv = BdUniqueId.gen();
    public static final BdUniqueId abe = BdUniqueId.gen();
    public static final BdUniqueId gww = BdUniqueId.gen();
    public static final BdUniqueId ZK = BdUniqueId.gen();
    public static final BdUniqueId gwx = BdUniqueId.gen();
    public static final BdUniqueId gwy = BdUniqueId.gen();
    public static final BdUniqueId gwz = BdUniqueId.gen();
    public static boolean gwA = false;
    private int gwB = 0;
    private boolean gwG = false;
    private ArrayList<PostData> gwH = null;
    private TbRichText gwI = null;
    private boolean gwL = false;
    private boolean gwO = false;
    private boolean gwP = false;
    public boolean gwS = false;
    public int aaC = 0;
    private boolean gwY = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean gwZ = false;
    public boolean gxa = false;
    public boolean gxc = false;
    public boolean gxd = true;
    public boolean gxe = false;
    public boolean gxf = false;
    private boolean gxh = false;
    private int gxi = 0;
    private boolean gxj = true;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData aae = new MetaData();
    private ArrayList<k> gwC = new ArrayList<>();
    private ArrayList<k> gwD = new ArrayList<>();
    private int gwE = 0;
    private int aaM = 0;
    private PraiseData aaq = new PraiseData();
    private an gwJ = new an();
    private c gwK = new c();
    private ArrayList<com.baidu.tbadk.data.c> aaZ = new ArrayList<>();

    public PostData() {
        this.gwF = null;
        this.gxb = 0;
        this.gwF = new ArrayList<>();
        this.gxb = 0;
    }

    public ArrayList<PostData> brS() {
        return this.gwH;
    }

    public void brT() {
        this.gwH.clear();
        this.gwH = null;
        this.gwG = false;
    }

    public void o(PostData postData) {
        if (postData != null) {
            if (this.gwH == null) {
                this.gwH = new ArrayList<>();
                if (v.v(this.gwF) > 2) {
                    this.gwH.addAll(v.a(this.gwF, 0, 2));
                } else {
                    this.gwH.addAll(this.gwF);
                }
            }
            this.gwH.add(postData);
        }
    }

    public void p(PostData postData) {
        if (postData != null && this.gwF != null) {
            this.gwF.add(postData);
            brX();
        }
    }

    public void sT(String str) {
        if (this.gwH != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.gwH.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.gwH.remove(next);
                    return;
                }
            }
        }
    }

    public void mn(boolean z) {
        this.gxj = z;
    }

    public boolean brU() {
        return this.gxj;
    }

    public void mo(boolean z) {
        this.gwG = z;
    }

    public boolean brV() {
        return this.gwG;
    }

    public ArrayList<PostData> brW() {
        return this.gwF;
    }

    public void brX() {
        this.gwE++;
    }

    public void brY() {
        this.gwE--;
    }

    public void tn(int i) {
        this.gwE = i;
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
        return this.fbL;
    }

    public int brZ() {
        return this.floor_num;
    }

    public void to(int i) {
        this.floor_num = i;
    }

    public boolean bsa() {
        return this.gwP;
    }

    public void mp(boolean z) {
        this.gwP = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = com.baidu.tbadk.core.util.an.s(j);
    }

    public MetaData rQ() {
        return this.aae;
    }

    public void a(MetaData metaData) {
        this.aae = metaData;
    }

    public void a(PraiseData praiseData) {
        this.aaq = praiseData;
    }

    public TbRichText bsb() {
        return this.gwI;
    }

    public void c(TbRichText tbRichText) {
        this.gwI = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bbZ() {
        return this.fvm;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.fvm = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bsc() {
        return this.gwN;
    }

    public SkinInfo sk() {
        return this.abd;
    }

    public void mq(boolean z) {
        this.gxh = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.gwI != null && this.gwI.JJ() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else if (this.aae != null && this.aae.getIs_bawu() == 1 && "manager".equals(this.aae.getBawu_type())) {
                str = " 吧主";
            } else if (this.aae == null || this.aae.getIs_bawu() != 1 || !"assist".equals(this.aae.getBawu_type())) {
                str = "";
            } else {
                str = " 小吧";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = rQ().getTShowInfoNew();
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
                                        if (aVar2 != null && aVar2.kn()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.gwI.isChanged = true;
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
            if (!StringUtils.isNull(this.aae.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.aae.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.aae == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.aae.getName_show() + str + "：");
                str2 = this.aae.getUserName();
                str3 = this.aae.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.aae.getSealPrefix())) {
                Bitmap cN = ak.cN(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
                if (cN != null) {
                    bitmapDrawable.setBounds(0, 0, cN.getWidth(), cN.getHeight());
                }
                com.baidu.tbadk.core.view.h hVar = new com.baidu.tbadk.core.view.h(bitmapDrawable);
                hVar.setOffset(com.baidu.adp.lib.util.l.e(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.aae.getSealPrefix().length() + 1;
                spannableString.setSpan(hVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.aae != null && this.aae.getIs_bawu() == 1))) {
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.C0126d.cp_link_tip_a);
                if (this.aae != null) {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.aae.getName_show().length() + 1, str.length() + sb2.length() + this.aae.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> JJ = this.gwI.JJ();
            if (JJ != null && JJ.size() > 0) {
                TbRichTextData tbRichTextData2 = JJ.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.JQ() != null) {
                    if (this.gxh) {
                        int indexOf = tbRichTextData2.JQ().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.JQ().delete(0, indexOf + 1);
                        }
                        this.gxh = false;
                    }
                    tbRichTextData2.fU(sb.length());
                    tbRichTextData2.JQ().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= JJ.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (JJ.get(i4) == null || JJ.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo JR = JJ.get(i4).JR();
                        JJ.remove(i4);
                        tbRichTextVoiceInfo = JR;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fU(sb.length());
                tbRichTextData.append(spannableString);
                JJ.add(0, tbRichTextData);
            }
        }
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap km;
        if (aVar == null || (km = aVar.km()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(km);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36));
        return bitmapDrawable;
    }

    public int bsd() {
        return this.gwE;
    }

    public void bX(Context context) {
        int type;
        int i;
        int i2;
        if (this.gwC != null) {
            int i3 = -1;
            int size = this.gwD.size();
            if (size > 0) {
                try {
                    i3 = this.gwD.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.gwC.size()) {
                k kVar = this.gwC.get(i4);
                if (k.bJ(i5, kVar.getType())) {
                    this.gwD.get(size - 1).b(kVar.bW(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.gwD.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.bW(context));
                        this.gwD.add(kVar2);
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
            if (this.gwI != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.gwI.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.gwD == null || this.gwD.size() == 0) {
                bX(context);
            }
            ArrayList<k> arrayList = this.gwD;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.brM() != null) {
                            sb.append((CharSequence) next.brM());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.k.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.k.voice_str));
                    } else if (next.getType() == 2) {
                        String gd = TbFaceManager.EZ().gd(next.getText());
                        if (gd != null) {
                            sb.append("[");
                            sb.append(gd);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !com.baidu.tbadk.core.util.an.isEmpty(next.brL())) {
                        sb.append("[").append(next.brL()).append("]");
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
                this.gwO = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aae = metaData;
                }
                if ((this.aae.getUserId() == null || this.aae.getUserId().length() <= 0 || this.aae.getUserId().equals("0")) && metaData2 != null) {
                    this.aae = metaData2;
                }
                this.gwI = TbRichTextView.a(context, subPostList.content, z);
                if (this.gwI != null) {
                    this.gwI.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.fbL = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aae = metaData;
                }
                this.gwZ = post.need_log.intValue() == 1;
                this.gxa = post.img_num_abtest.intValue() == 1;
                this.gwR = new az();
                this.gwR.parserProtobuf(post.from_forum);
                if (this.aae.getUserId() == null || this.aae.getUserId().length() <= 0 || this.aae.getUserId().equals("0")) {
                    this.aae.parserProtobuf(post.author);
                }
                if (this.aae != null && context != null) {
                    this.gwV = this.aae.getUserName() + context.getResources().getString(d.k.somebodys_portrait);
                    this.gwW = String.format(TbadkCoreApplication.getInst().getString(d.k.degree_in_forum), Integer.valueOf(this.aae.getLevel_id()));
                }
                this.gwL = post.is_ntitle.intValue() == 1;
                this.gwE = post.sub_post_number.intValue();
                this.gwQ = new h(post.tpoint_post);
                this.gwI = TbRichTextView.a(context, post.content, true);
                if (this.gwI != null) {
                    this.gwI.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.gwI.fT(this.floor_num);
                    if (this.aae != null) {
                        this.gwI.setAuthorId(this.aae.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.gwO = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.gwF.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.gwK.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.gwM = new com.baidu.tbadk.data.c();
                    this.gwM.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.gwN = new com.baidu.tbadk.data.f();
                    this.gwN.a(post.lbs_info);
                }
                this.aaM = post.storecount.intValue();
                this.gwJ.a(post.present);
                this.aaq.setUserMap(this.userMap);
                this.aaq.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.fvm = new SmallTailInfo();
                    this.fvm.id = post.signature.signature_id.intValue();
                    this.fvm.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.fvm.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.fvm.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.fvm.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.aaZ.add(cVar);
                    }
                }
                this.abd = post.skin_info;
                this.abg = post.lego_card;
                this.gwX = post.tpoint_post;
                if (post.agree != null) {
                    this.gwY = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                } else {
                    this.gwY = false;
                }
                this.gxf = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.abL = new OriginalThreadInfo();
                    this.abL.parser(post.origin_thread_info);
                } else {
                    this.abL = null;
                }
                this.gxi = post.is_fold.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int ftz;

        public CustomForegroundColorSpan(int i) {
            super(ak.getColor(i));
            this.ftz = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ak.getColor(this.ftz));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> gxp;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.gxp = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ak.getColor(d.C0126d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            if (this.mName != null && this.mId != null && this.gxp != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.gxp.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bZ(Context context) {
        ArrayList<TbRichTextData> JJ;
        if (this.gwI == null || (JJ = this.gwI.JJ()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = JJ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.JQ().toString());
            } else if (next.getType() == 17) {
                String str = next.JU().mGifInfo.mSharpText;
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

    public String bse() {
        ArrayList<TbRichTextData> JJ;
        String str;
        if (this.gwI == null || (JJ = this.gwI.JJ()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = JJ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.JQ().toString());
                } else if (next.getType() == 17) {
                    if (next.JU() != null && next.JU().mGifInfo != null && (str = next.JU().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo bsf() {
        ArrayList<TbRichTextData> JJ;
        if (this.gwI != null && (JJ = this.gwI.JJ()) != null) {
            Iterator<TbRichTextData> it = JJ.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.JP().getWidth();
                    preLoadImageInfo.height = next.JP().getHeight();
                    preLoadImageInfo.imgUrl = next.JP().Kc();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.JV().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.JV().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.JV().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bsg() {
        j brE;
        PreLoadImageInfo bsf = bsf();
        if (bsf != null && !StringUtils.isNull(bsf.imgUrl)) {
            return bsf.imgUrl;
        }
        if (this.gwQ != null && (brE = this.gwQ.brE()) != null && !StringUtils.isNull(brE.brJ())) {
            return brE.brJ();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> JJ;
        if (this.gwI == null || (JJ = this.gwI.JJ()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = JJ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.JP().getWidth();
                preLoadImageInfo.height = next.JP().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.JP().Kh()) {
                    preLoadImageInfo.imgUrl = next.JP().Kd();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.JP().Kc();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.JU() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.JU().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.JU().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.JU();
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
        if (this.aae == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.aae.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.gwB == 52) {
            return gwy;
        }
        if (this.gwB == 1) {
            return abe;
        }
        if (this.gwB == 36) {
            return gww;
        }
        if (this.gwB == 40 || this.gwB == 50) {
            return ZK;
        }
        if (this.gwB == 41) {
            return gwx;
        }
        if (this.gwB == 53) {
            return gwz;
        }
        if (brZ() == 1) {
            return gwu;
        }
        return gwv;
    }

    public void setPostType(int i) {
        this.gwB = i;
    }

    public an bsh() {
        return this.gwJ;
    }

    public void a(an anVar) {
        this.gwJ = anVar;
    }

    public h bsi() {
        return this.gwQ;
    }

    public com.baidu.tbadk.widget.richText.f JT() {
        if (this.gwU != null) {
            return this.gwU;
        }
        if (this.gwI != null && v.v(this.gwI.JJ()) > 0) {
            Iterator<TbRichTextData> it = this.gwI.JJ().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.gwU = next.JT();
                    return this.gwU;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo JR() {
        if (this.apt != null) {
            return this.apt;
        }
        if (this.gwI != null && v.v(this.gwI.JJ()) > 0) {
            Iterator<TbRichTextData> it = this.gwI.JJ().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.apt = next.JR();
                    return this.apt;
                }
            }
        }
        return null;
    }

    public String bsj() {
        return this.gwV;
    }

    public String sH() {
        return this.abg;
    }

    public void sK() {
        if (this.aaC == 0) {
            this.aaC = 1;
        }
    }

    public long bsk() {
        return this.agreeNum;
    }

    public void cU(long j) {
        this.agreeNum = j;
    }

    public boolean bsl() {
        return this.hasAgree;
    }

    public void mr(boolean z) {
        this.hasAgree = z;
    }

    public OriginalThreadInfo bsm() {
        return this.abL;
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        this.abL = originalThreadInfo;
    }

    public int bsn() {
        return this.gxi;
    }
}
