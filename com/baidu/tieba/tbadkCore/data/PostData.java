package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.al;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.w;
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
public class PostData implements v, ah {
    private SkinInfo YX;
    private String Za;
    private TbRichTextVoiceInfo aMw;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String ehB;
    private SmallTailInfo ewd;
    private com.baidu.tbadk.data.b fuA;
    private com.baidu.tbadk.data.g fuB;
    private h fuE;
    private com.baidu.tbadk.widget.richText.e fuF;
    private String fuG;
    private String fuH;
    private TPointPost fuJ;
    private ArrayList<PostData> fuu;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId fug = BdUniqueId.gen();
    public static final BdUniqueId fuh = BdUniqueId.gen();
    public static final BdUniqueId YY = BdUniqueId.gen();
    public static final BdUniqueId fui = BdUniqueId.gen();
    public static final BdUniqueId XM = BdUniqueId.gen();
    public static final BdUniqueId fuj = BdUniqueId.gen();
    public static final BdUniqueId fuk = BdUniqueId.gen();
    public static final BdUniqueId ful = BdUniqueId.gen();
    public static final BdUniqueId fum = BdUniqueId.gen();
    public static final BdUniqueId fun = BdUniqueId.gen();
    public static final BdUniqueId eim = BdUniqueId.gen();
    public static final BdUniqueId fuo = BdUniqueId.gen();
    public static final BdUniqueId fup = BdUniqueId.gen();
    public static boolean fuq = false;
    private int fur = 0;
    private boolean fuv = false;
    private ArrayList<PostData> fuw = null;
    private TbRichText dpT = null;
    private boolean fuz = false;
    private boolean fuC = false;
    private boolean fuD = false;
    public int Yz = 0;
    public boolean fuI = false;
    private boolean fuK = false;
    private long fuL = 0;
    private boolean fuM = false;
    private String id = null;
    private String title = null;
    private int fus = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<k> dnF = new ArrayList<>();
    private ArrayList<k> dow = new ArrayList<>();
    private int fut = 0;
    private int YJ = 0;
    private PraiseData Yn = new PraiseData();
    private ar fux = new ar();
    private c fuy = new c();
    private ArrayList<com.baidu.tbadk.data.b> YV = new ArrayList<>();

    public PostData() {
        this.fuu = null;
        this.fuu = new ArrayList<>();
    }

    public ArrayList<PostData> bhw() {
        return this.fuw;
    }

    public void t(PostData postData) {
        if (postData != null) {
            if (this.fuw == null) {
                this.fuw = new ArrayList<>();
                if (x.p(this.fuu) > 2) {
                    this.fuw.addAll(x.a(this.fuu, 0, 2));
                } else {
                    this.fuw.addAll(this.fuu);
                }
            }
            this.fuw.add(postData);
        }
    }

    public void u(PostData postData) {
        if (postData != null && this.fuu != null) {
            this.fuu.add(postData);
            bhB();
        }
    }

    public void pM(String str) {
        if (this.fuw != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.fuw.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.fuw.remove(next);
                    return;
                }
            }
        }
    }

    public void lf(boolean z) {
        this.fuv = z;
    }

    public boolean bhx() {
        return this.fuv;
    }

    public TPointPost bhy() {
        return this.fuJ;
    }

    public c bhz() {
        return this.fuy;
    }

    public ArrayList<PostData> bhA() {
        return this.fuu;
    }

    public void bhB() {
        this.fut++;
    }

    public void bhC() {
        this.fut--;
    }

    public void rT(int i) {
        this.fut = i;
    }

    public boolean isGiftPost() {
        return this.fuC;
    }

    public void setIsGiftPost(boolean z) {
        this.fuC = z;
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String aJd() {
        return this.ehB;
    }

    public int bhD() {
        return this.fus;
    }

    public void rU(int i) {
        this.fus = i;
    }

    public boolean bhE() {
        return this.fuD;
    }

    public void lg(boolean z) {
        this.fuD = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = au.q(j);
    }

    public String bhF() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public void a(PraiseData praiseData) {
        this.Yn = praiseData;
    }

    public TbRichText aws() {
        return this.dpT;
    }

    public void f(TbRichText tbRichText) {
        this.dpT = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aOS() {
        return this.ewd;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.ewd = smallTailInfo;
    }

    public com.baidu.tbadk.data.g bhG() {
        return this.fuB;
    }

    public SkinInfo sl() {
        return this.YX;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.dpT != null && this.dpT.HP() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                tShowInfoNew.size();
            }
            String str3 = z ? " 楼主" : "";
            TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new p(this, it.next(), uniqueId), 0, 1);
                    eVar.d(0, 0, TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(w.f.ds32), TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(w.f.ds32));
                    arrayList.add(eVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.author.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.author.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.author == null) {
                str = null;
                spannableString = new SpannableString(String.valueOf(sb2) + str3 + "：");
                str2 = null;
            } else {
                spannableString = new SpannableString(String.valueOf(sb2) + this.author.getName_show() + str3 + "：");
                str = this.author.getUserName();
                str2 = this.author.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.author.getSealPrefix())) {
                Bitmap cL = aq.cL(w.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cL);
                if (cL != null) {
                    bitmapDrawable.setBounds(0, 0, cL.getWidth(), cL.getHeight());
                }
                al alVar = new al(bitmapDrawable);
                alVar.setOffset(com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds2));
                int size = arrayList.size() + this.author.getSealPrefix().length() + 1;
                spannableString.setSpan(alVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str, str2), 0, spannableString.length(), 18);
            if (z) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds28));
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(w.e.cp_link_tip_a);
                if (this.author != null) {
                    spannableString.setSpan(absoluteSizeSpan, sb2.length() + this.author.getName_show().length() + 1, sb2.length() + this.author.getName_show().length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(absoluteSizeSpan, sb2.length(), sb2.length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> HP = this.dpT.HP();
            if (HP != null && HP.size() > 0) {
                TbRichTextData tbRichTextData2 = HP.get(0);
                if (tbRichTextData2.HW() != null) {
                    tbRichTextData2.fq(sb.length());
                    tbRichTextData2.HW().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= HP.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (HP.get(i4) == null || HP.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo HX = HP.get(i4).HX();
                        HP.remove(i4);
                        tbRichTextVoiceInfo = HX;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fq(sb.length());
                tbRichTextData.append(spannableString);
                HP.add(0, tbRichTextData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap kN;
        if (aVar == null || (kN = aVar.kN()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kN);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(w.f.ds36), TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(w.f.ds36));
        return bitmapDrawable;
    }

    public int bhH() {
        return this.fut;
    }

    public void bR(Context context) {
        int type;
        int i;
        int i2;
        if (this.dnF != null) {
            int i3 = -1;
            int size = this.dow.size();
            if (size > 0) {
                try {
                    i3 = this.dow.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.dnF.size()) {
                k kVar = this.dnF.get(i4);
                if (k.bs(i5, kVar.getType())) {
                    this.dow.get(size - 1).a(kVar.bQ(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.dow.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.a(kVar.bQ(context));
                        this.dow.add(kVar2);
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

    public void bS(Context context) {
        try {
            if (this.dpT != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dpT.toString());
                clipboardManager.getText();
                return;
            }
            if (this.dow == null || this.dow.size() == 0) {
                bR(context);
            }
            ArrayList<k> arrayList = this.dow;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bho() != null) {
                            sb.append((CharSequence) next.bho());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(w.l.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(w.l.voice_str));
                    } else if (next.getType() == 2) {
                        String fe = TbFaceManager.Ek().fe(next.getText());
                        if (fe != null) {
                            sb.append("[");
                            sb.append(fe);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !au.isEmpty(next.bhn())) {
                        sb.append("[").append(next.bhn()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                clipboardManager2.getText();
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
                this.fus = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = au.q(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.fuC = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dpT = TbRichTextView.b(context, subPostList.content, z);
                if (this.dpT != null) {
                    this.dpT.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.fus = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = au.q(this.time);
                this.ehB = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if (this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.fuG = String.valueOf(this.author.getUserName()) + context.getResources().getString(w.l.somebodys_portrait);
                    this.fuH = String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.fuz = post.is_ntitle.intValue() == 1;
                this.fut = post.sub_post_number.intValue();
                this.fuE = new h(post.tpoint_post);
                this.dpT = TbRichTextView.b(context, post.content, true);
                if (this.dpT != null) {
                    this.dpT.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.dpT.fp(this.fus);
                    if (this.author != null) {
                        this.dpT.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.fuC = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.fuu.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.fuy.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.fuA = new com.baidu.tbadk.data.b();
                    this.fuA.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.fuB = new com.baidu.tbadk.data.g();
                    this.fuB.a(post.lbs_info);
                }
                this.YJ = post.storecount.intValue();
                this.fux.a(post.present);
                this.Yn.setUserMap(this.userMap);
                this.Yn.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.ewd = new SmallTailInfo();
                    this.ewd.id = post.signature.signature_id.intValue();
                    this.ewd.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.ewd.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.ewd.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.ewd.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(post.ext_tails.get(i2));
                        this.YV.add(bVar);
                    }
                }
                this.YX = post.skin_info;
                this.Za = post.lego_card;
                this.fuJ = post.tpoint_post;
                if (post.agree != null) {
                    this.fuK = true;
                    this.fuM = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.fuL = post.agree.agree_num.longValue();
                        return;
                    } else {
                        this.fuL = 0L;
                        return;
                    }
                }
                this.fuK = false;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int eup;

        public CustomForegroundColorSpan(int i) {
            super(aq.getColor(i));
            this.eup = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aq.getColor(this.eup));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> fuS;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.fuS = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aq.getColor(w.e.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.fuS != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.fuS.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bT(Context context) {
        ArrayList<TbRichTextData> HP;
        if (this.dpT == null || (HP = this.dpT.HP()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = HP.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.HW().toString());
            } else if (next.getType() == 17) {
                String str = next.Ia().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(w.l.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(w.l.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(w.l.msglist_video) + "]");
            } else if (next.getType() == 1536) {
                stringBuffer.append("[" + context.getString(w.l.msglist_graffiti) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public PreLoadImageInfo bhI() {
        ArrayList<TbRichTextData> HP;
        if (this.dpT != null && (HP = this.dpT.HP()) != null) {
            Iterator<TbRichTextData> it = HP.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.HV().getWidth();
                    preLoadImageInfo.height = next.HV().getHeight();
                    preLoadImageInfo.imgUrl = next.HV().Ij();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 1536) {
                    if (next.Ie() == null || TextUtils.isEmpty(next.Ie().url)) {
                        return null;
                    }
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.imgUrl = next.Ie().url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bhJ() {
        j bhd;
        PreLoadImageInfo bhI = bhI();
        if (bhI != null && !StringUtils.isNull(bhI.imgUrl)) {
            return bhI.imgUrl;
        }
        if (this.fuE != null && (bhd = this.fuE.bhd()) != null && !StringUtils.isNull(bhd.bhk())) {
            return bhd.bhk();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> HP;
        if (this.dpT == null || (HP = this.dpT.HP()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = HP.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.HV().getWidth();
                preLoadImageInfo.height = next.HV().getHeight();
                preLoadImageInfo.imgUrl = next.HV().Ij();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.Ia() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.Ia().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.Ia().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.Ia();
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
        if (this.author == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.author.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.fur == 52) {
            return fup;
        }
        if (this.fur == 2) {
            return fuh;
        }
        if (this.fur == 1) {
            return YY;
        }
        if (this.fur == 36) {
            return fui;
        }
        if (this.fur == 40 || this.fur == 50) {
            return XM;
        }
        if (this.fur == 41) {
            return fum;
        }
        if (fuq) {
            if (this.fuE != null && this.fuE.ftO) {
                int bhh = this.fuE.bhh();
                if (bhh == 2) {
                    return fuj;
                }
                if (bhh == 1) {
                    return fuk;
                }
                if (bhh == 3) {
                    return ful;
                }
                return fug;
            } else if (this.fur == 48) {
                return fuo;
            }
        }
        return fug;
    }

    public void setPostType(int i) {
        this.fur = i;
    }

    public ar bhK() {
        return this.fux;
    }

    public void a(ar arVar) {
        this.fux = arVar;
    }

    public h bhL() {
        return this.fuE;
    }

    public com.baidu.tbadk.widget.richText.e HZ() {
        if (this.fuF != null) {
            return this.fuF;
        }
        if (this.dpT != null && x.p(this.dpT.HP()) > 0) {
            Iterator<TbRichTextData> it = this.dpT.HP().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.fuF = next.HZ();
                    return this.fuF;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo HX() {
        if (this.aMw != null) {
            return this.aMw;
        }
        if (this.dpT != null && x.p(this.dpT.HP()) > 0) {
            Iterator<TbRichTextData> it = this.dpT.HP().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aMw = next.HX();
                    return this.aMw;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.b> bhM() {
        return this.YV;
    }

    public String bhN() {
        return this.fuG;
    }

    public String bhO() {
        return this.fuH;
    }

    public String sL() {
        return this.Za;
    }

    public void sO() {
        if (this.Yz == 0) {
            this.Yz = 1;
        }
    }

    public boolean bhP() {
        return this.fuK;
    }

    public long bhQ() {
        return this.fuL;
    }

    public void cB(long j) {
        this.fuL = j;
    }

    public boolean bhR() {
        return this.fuM;
    }

    public void lh(boolean z) {
        this.fuM = z;
    }
}
