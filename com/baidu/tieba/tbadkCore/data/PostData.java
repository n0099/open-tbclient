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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
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
    private SkinInfo Zo;
    private String Zr;
    private TbRichTextVoiceInfo aMO;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String ehY;
    private SmallTailInfo ewy;
    private com.baidu.tbadk.data.b fyA;
    private com.baidu.tbadk.data.g fyB;
    private h fyE;
    private com.baidu.tbadk.widget.richText.e fyF;
    private String fyG;
    private String fyH;
    private TPointPost fyJ;
    private ArrayList<PostData> fyu;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId fyg = BdUniqueId.gen();
    public static final BdUniqueId fyh = BdUniqueId.gen();
    public static final BdUniqueId Zp = BdUniqueId.gen();
    public static final BdUniqueId fyi = BdUniqueId.gen();
    public static final BdUniqueId Yd = BdUniqueId.gen();
    public static final BdUniqueId fyj = BdUniqueId.gen();
    public static final BdUniqueId fyk = BdUniqueId.gen();
    public static final BdUniqueId fyl = BdUniqueId.gen();
    public static final BdUniqueId fym = BdUniqueId.gen();
    public static final BdUniqueId fyn = BdUniqueId.gen();
    public static final BdUniqueId eiJ = BdUniqueId.gen();
    public static final BdUniqueId fyo = BdUniqueId.gen();
    public static final BdUniqueId fyp = BdUniqueId.gen();
    public static boolean fyq = false;
    private int fyr = 0;
    private boolean fyv = false;
    private ArrayList<PostData> fyw = null;
    private TbRichText dqJ = null;
    private boolean fyz = false;
    private boolean fyC = false;
    private boolean fyD = false;
    public int YQ = 0;
    public boolean fyI = false;
    private boolean fyK = false;
    private long fyL = 0;
    private boolean fyM = false;
    private String id = null;
    private String title = null;
    private int fys = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<k> dow = new ArrayList<>();
    private ArrayList<k> dpm = new ArrayList<>();
    private int fyt = 0;
    private int Za = 0;
    private PraiseData YE = new PraiseData();
    private aq fyx = new aq();
    private c fyy = new c();
    private ArrayList<com.baidu.tbadk.data.b> Zm = new ArrayList<>();

    public PostData() {
        this.fyu = null;
        this.fyu = new ArrayList<>();
    }

    public ArrayList<PostData> bji() {
        return this.fyw;
    }

    public void t(PostData postData) {
        if (postData != null) {
            if (this.fyw == null) {
                this.fyw = new ArrayList<>();
                if (x.p(this.fyu) > 2) {
                    this.fyw.addAll(x.a(this.fyu, 0, 2));
                } else {
                    this.fyw.addAll(this.fyu);
                }
            }
            this.fyw.add(postData);
        }
    }

    public void u(PostData postData) {
        if (postData != null && this.fyu != null) {
            this.fyu.add(postData);
            bjn();
        }
    }

    public void qe(String str) {
        if (this.fyw != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.fyw.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.fyw.remove(next);
                    return;
                }
            }
        }
    }

    public void ls(boolean z) {
        this.fyv = z;
    }

    public boolean bjj() {
        return this.fyv;
    }

    public TPointPost bjk() {
        return this.fyJ;
    }

    public c bjl() {
        return this.fyy;
    }

    public ArrayList<PostData> bjm() {
        return this.fyu;
    }

    public void bjn() {
        this.fyt++;
    }

    public void bjo() {
        this.fyt--;
    }

    public void rX(int i) {
        this.fyt = i;
    }

    public boolean isGiftPost() {
        return this.fyC;
    }

    public void setIsGiftPost(boolean z) {
        this.fyC = z;
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

    public String aKl() {
        return this.ehY;
    }

    public int bjp() {
        return this.fys;
    }

    public void rY(int i) {
        this.fys = i;
    }

    public boolean bjq() {
        return this.fyD;
    }

    public void lt(boolean z) {
        this.fyD = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = au.q(j);
    }

    public String bjr() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public void a(PraiseData praiseData) {
        this.YE = praiseData;
    }

    public TbRichText axm() {
        return this.dqJ;
    }

    public void f(TbRichText tbRichText) {
        this.dqJ = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aQc() {
        return this.ewy;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.ewy = smallTailInfo;
    }

    public com.baidu.tbadk.data.g bjs() {
        return this.fyB;
    }

    public SkinInfo sJ() {
        return this.Zo;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.dqJ != null && this.dqJ.Io() != null) {
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
                Bitmap cO = com.baidu.tbadk.core.util.aq.cO(w.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
                if (cO != null) {
                    bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
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
            ArrayList<TbRichTextData> Io = this.dqJ.Io();
            if (Io != null && Io.size() > 0) {
                TbRichTextData tbRichTextData2 = Io.get(0);
                if (tbRichTextData2.Iv() != null) {
                    tbRichTextData2.ft(sb.length());
                    tbRichTextData2.Iv().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Io.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (Io.get(i4) == null || Io.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo Iw = Io.get(i4).Iw();
                        Io.remove(i4);
                        tbRichTextVoiceInfo = Iw;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.ft(sb.length());
                tbRichTextData.append(spannableString);
                Io.add(0, tbRichTextData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap kS;
        if (aVar == null || (kS = aVar.kS()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kS);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(w.f.ds36), TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(w.f.ds36));
        return bitmapDrawable;
    }

    public int bjt() {
        return this.fyt;
    }

    public void bL(Context context) {
        int type;
        int i;
        int i2;
        if (this.dow != null) {
            int i3 = -1;
            int size = this.dpm.size();
            if (size > 0) {
                try {
                    i3 = this.dpm.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.dow.size()) {
                k kVar = this.dow.get(i4);
                if (k.bp(i5, kVar.getType())) {
                    this.dpm.get(size - 1).a(kVar.bK(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.dpm.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.a(kVar.bK(context));
                        this.dpm.add(kVar2);
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

    public void bM(Context context) {
        try {
            if (this.dqJ != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dqJ.toString());
                clipboardManager.getText();
                return;
            }
            if (this.dpm == null || this.dpm.size() == 0) {
                bL(context);
            }
            ArrayList<k> arrayList = this.dpm;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bja() != null) {
                            sb.append((CharSequence) next.bja());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(w.l.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(w.l.voice_str));
                    } else if (next.getType() == 2) {
                        String fk = TbFaceManager.EI().fk(next.getText());
                        if (fk != null) {
                            sb.append("[");
                            sb.append(fk);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !au.isEmpty(next.biZ())) {
                        sb.append("[").append(next.biZ()).append("]");
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
                this.fys = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = au.q(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.fyC = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dqJ = TbRichTextView.b(context, subPostList.content, z);
                if (this.dqJ != null) {
                    this.dqJ.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.fys = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = au.q(this.time);
                this.ehY = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if (this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.fyG = String.valueOf(this.author.getUserName()) + context.getResources().getString(w.l.somebodys_portrait);
                    this.fyH = String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.fyz = post.is_ntitle.intValue() == 1;
                this.fyt = post.sub_post_number.intValue();
                this.fyE = new h(post.tpoint_post);
                this.dqJ = TbRichTextView.b(context, post.content, true);
                if (this.dqJ != null) {
                    this.dqJ.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.dqJ.fs(this.fys);
                    if (this.author != null) {
                        this.dqJ.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.fyC = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.fyu.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.fyy.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.fyA = new com.baidu.tbadk.data.b();
                    this.fyA.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.fyB = new com.baidu.tbadk.data.g();
                    this.fyB.a(post.lbs_info);
                }
                this.Za = post.storecount.intValue();
                this.fyx.a(post.present);
                this.YE.setUserMap(this.userMap);
                this.YE.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.ewy = new SmallTailInfo();
                    this.ewy.id = post.signature.signature_id.intValue();
                    this.ewy.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.ewy.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.ewy.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.ewy.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(post.ext_tails.get(i2));
                        this.Zm.add(bVar);
                    }
                }
                this.Zo = post.skin_info;
                this.Zr = post.lego_card;
                this.fyJ = post.tpoint_post;
                if (post.agree != null) {
                    this.fyK = true;
                    this.fyM = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.fyL = post.agree.agree_num.longValue();
                        return;
                    } else {
                        this.fyL = 0L;
                        return;
                    }
                }
                this.fyK = false;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int euM;

        public CustomForegroundColorSpan(int i) {
            super(com.baidu.tbadk.core.util.aq.getColor(i));
            this.euM = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(com.baidu.tbadk.core.util.aq.getColor(this.euM));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> fyS;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.fyS = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.fyS != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.fyS.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bN(Context context) {
        ArrayList<TbRichTextData> Io;
        if (this.dqJ == null || (Io = this.dqJ.Io()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Io.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Iv().toString());
            } else if (next.getType() == 17) {
                String str = next.Iz().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(w.l.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(w.l.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(w.l.msglist_video) + "]");
            } else if (next.getType() == 1536) {
                stringBuffer.append("[" + context.getString(w.l.graffiti) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public PreLoadImageInfo bju() {
        ArrayList<TbRichTextData> Io;
        if (this.dqJ != null && (Io = this.dqJ.Io()) != null) {
            Iterator<TbRichTextData> it = Io.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.Iu().getWidth();
                    preLoadImageInfo.height = next.Iu().getHeight();
                    preLoadImageInfo.imgUrl = next.Iu().II();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 1536) {
                    if (next.ID() == null || TextUtils.isEmpty(next.ID().url)) {
                        return null;
                    }
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.imgUrl = next.ID().url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bjv() {
        j biP;
        PreLoadImageInfo bju = bju();
        if (bju != null && !StringUtils.isNull(bju.imgUrl)) {
            return bju.imgUrl;
        }
        if (this.fyE != null && (biP = this.fyE.biP()) != null && !StringUtils.isNull(biP.biW())) {
            return biP.biW();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Io;
        if (this.dqJ == null || (Io = this.dqJ.Io()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Io.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.Iu().getWidth();
                preLoadImageInfo.height = next.Iu().getHeight();
                preLoadImageInfo.imgUrl = next.Iu().II();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.Iz() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.Iz().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.Iz().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.Iz();
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
        if (this.fyr == 52) {
            return fyp;
        }
        if (this.fyr == 2) {
            return fyh;
        }
        if (this.fyr == 1) {
            return Zp;
        }
        if (this.fyr == 36) {
            return fyi;
        }
        if (this.fyr == 40 || this.fyr == 50) {
            return Yd;
        }
        if (this.fyr == 41) {
            return fym;
        }
        if (fyq) {
            if (this.fyE != null && this.fyE.fxO) {
                int biT = this.fyE.biT();
                if (biT == 2) {
                    return fyj;
                }
                if (biT == 1) {
                    return fyk;
                }
                if (biT == 3) {
                    return fyl;
                }
                return fyg;
            } else if (this.fyr == 48) {
                return fyo;
            }
        }
        return fyg;
    }

    public void setPostType(int i) {
        this.fyr = i;
    }

    public aq bjw() {
        return this.fyx;
    }

    public void a(aq aqVar) {
        this.fyx = aqVar;
    }

    public h bjx() {
        return this.fyE;
    }

    public com.baidu.tbadk.widget.richText.e Iy() {
        if (this.fyF != null) {
            return this.fyF;
        }
        if (this.dqJ != null && x.p(this.dqJ.Io()) > 0) {
            Iterator<TbRichTextData> it = this.dqJ.Io().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.fyF = next.Iy();
                    return this.fyF;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo Iw() {
        if (this.aMO != null) {
            return this.aMO;
        }
        if (this.dqJ != null && x.p(this.dqJ.Io()) > 0) {
            Iterator<TbRichTextData> it = this.dqJ.Io().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aMO = next.Iw();
                    return this.aMO;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.b> bjy() {
        return this.Zm;
    }

    public String bjz() {
        return this.fyG;
    }

    public String bjA() {
        return this.fyH;
    }

    public String tj() {
        return this.Zr;
    }

    public void tm() {
        if (this.YQ == 0) {
            this.YQ = 1;
        }
    }

    public boolean bjB() {
        return this.fyK;
    }

    public long bjC() {
        return this.fyL;
    }

    public void cB(long j) {
        this.fyL = j;
    }

    public boolean bjD() {
        return this.fyM;
    }

    public void lu(boolean z) {
        this.fyM = z;
    }
}
