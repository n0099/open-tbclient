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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
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
import tbclient.PbContent;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements com.baidu.adp.widget.ListView.o, ae {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private SkinInfo dGG;
    private String dGJ;
    private OriginalThreadInfo dHm;
    private TbRichTextVoiceInfo dXe;
    private String jEA;
    private SmallTailInfo jZV;
    private String lkT;
    private ArrayList<PostData> lkX;
    private boolean llC;
    private boolean llF;
    public an llH;
    private com.baidu.tbadk.data.c lle;
    private com.baidu.tbadk.data.f llf;
    private i lli;
    private bg llj;
    public boolean lll;
    private com.baidu.tbadk.widget.richText.i llm;
    private String lln;
    private String llo;
    private TPointPost llp;
    public int lls;
    public boolean llv;
    public AlaLiveInfoCoreData lly;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId lkI = BdUniqueId.gen();
    public static final BdUniqueId lkJ = BdUniqueId.gen();
    public static final BdUniqueId dGH = BdUniqueId.gen();
    public static final BdUniqueId lkK = BdUniqueId.gen();
    public static final BdUniqueId dEV = BdUniqueId.gen();
    public static final BdUniqueId lkL = BdUniqueId.gen();
    public static final BdUniqueId lkM = BdUniqueId.gen();
    public static final BdUniqueId lkN = BdUniqueId.gen();
    public static final BdUniqueId lkO = BdUniqueId.gen();
    public static final BdUniqueId lkP = BdUniqueId.gen();
    public static boolean lkQ = false;
    private int lkR = 0;
    private boolean lkY = false;
    private ArrayList<PostData> lkZ = null;
    private TbRichText lla = null;
    private boolean lld = false;
    private boolean llg = false;
    private boolean llh = false;
    public boolean llk = false;
    public int dGg = 0;
    private boolean llq = false;
    public boolean huD = false;
    public boolean llr = false;
    public boolean llt = false;
    public boolean llu = true;
    public boolean llw = false;
    public boolean llx = false;
    private boolean llz = false;
    private int llA = 0;
    private boolean llB = true;
    public boolean llD = false;
    public boolean llE = false;
    public boolean llG = false;
    public boolean llI = false;
    public boolean llJ = false;
    private b llK = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.llH != null) {
                an aUR = PostData.this.llH.aUR();
                aUR.delete("obj_locate");
                aUR.ag("obj_locate", 7);
                TiebaStatic.log(aUR);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int lkS = 0;
    private long time = 0;
    private String fzt = null;
    private MetaData dFJ = new MetaData();
    private ArrayList<l> lkU = new ArrayList<>();
    private ArrayList<l> lkV = new ArrayList<>();
    private int lkW = 0;
    private int dGr = 0;
    private PraiseData dFU = new PraiseData();
    private aq llb = new aq();
    private c llc = new c();
    private ArrayList<com.baidu.tbadk.data.c> dGD = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.lkX = null;
        this.lls = 0;
        this.lkX = new ArrayList<>();
        this.lls = 0;
    }

    public void uq(boolean z) {
        this.llC = z;
    }

    public boolean ddm() {
        return this.llC;
    }

    public ArrayList<PostData> ddn() {
        return this.lkZ;
    }

    public void ddo() {
        this.lkZ.clear();
        this.lkZ = null;
        this.lkY = false;
    }

    public void w(PostData postData) {
        if (postData != null) {
            if (this.lkZ == null) {
                this.lkZ = new ArrayList<>();
                if (v.getCount(this.lkX) > 2) {
                    this.lkZ.addAll(v.subList(this.lkX, 0, 2));
                } else {
                    this.lkZ.addAll(this.lkX);
                }
            }
            this.lkZ.add(postData);
        }
    }

    public void x(PostData postData) {
        if (postData != null && this.lkX != null) {
            this.lkX.add(postData);
            dds();
        }
    }

    public void MB(String str) {
        if (this.lkZ != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.lkZ.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.lkZ.remove(next);
                    return;
                }
            }
        }
    }

    public void ur(boolean z) {
        this.llB = z;
    }

    public boolean ddp() {
        return this.llB;
    }

    public void us(boolean z) {
        this.lkY = z;
    }

    public boolean ddq() {
        return this.lkY;
    }

    public ArrayList<PostData> ddr() {
        return this.lkX;
    }

    public void dds() {
        this.lkW++;
    }

    public void ddt() {
        this.lkW--;
    }

    public void DR(int i) {
        this.lkW = i;
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

    public int ddu() {
        return this.lkS;
    }

    public void DS(int i) {
        this.lkS = i;
    }

    public boolean ddv() {
        return this.llh;
    }

    public void ut(boolean z) {
        this.llh = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.fzt = com.baidu.tbadk.core.util.aq.getFormatTime(j);
    }

    public MetaData aQx() {
        return this.dFJ;
    }

    public void a(MetaData metaData) {
        this.dFJ = metaData;
    }

    public void a(PraiseData praiseData) {
        this.dFU = praiseData;
    }

    public TbRichText ddw() {
        return this.lla;
    }

    public void c(TbRichText tbRichText) {
        this.lla = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo cJX() {
        return this.jZV;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.jZV = smallTailInfo;
    }

    public com.baidu.tbadk.data.f ddx() {
        return this.llf;
    }

    public SkinInfo aQU() {
        return this.dGG;
    }

    public void uu(boolean z) {
        this.llz = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.lla != null && this.lla.biq() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.dFJ != null && this.dFJ.getIs_bawu() == 1) {
                    if (this.llC) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.dFJ.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.dFJ.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.dFJ.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.dFJ.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = aQx().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.kX().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.kX().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.lla.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.j(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.dFJ.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.dFJ.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.dFJ == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.dFJ.getName_show() + str + "：");
                str2 = this.dFJ.getUserName();
                str3 = this.dFJ.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.dFJ.getSealPrefix())) {
                Bitmap bitmap = am.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.dFJ.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.llK), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.dFJ != null && this.dFJ.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b e = e(z, this.dFJ != null && this.dFJ.getIs_bawu() == 1, str);
                if (e != null) {
                    if (this.dFJ != null) {
                        int i3 = 0;
                        if (this.dFJ.getName_show() != null) {
                            i3 = this.dFJ.getName_show().length();
                        }
                        spannableString.setSpan(e, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> biq = this.lla.biq();
            if (biq != null && biq.size() > 0) {
                TbRichTextData tbRichTextData2 = biq.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bix() != null) {
                    if (this.llz) {
                        int indexOf = tbRichTextData2.bix().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bix().delete(0, indexOf + 1);
                        }
                        this.llz = false;
                    }
                    tbRichTextData2.ok(sb.length());
                    tbRichTextData2.bix().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= biq.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (biq.get(i5) == null || biq.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo biy = biq.get(i5).biy();
                            biq.remove(i5);
                            tbRichTextVoiceInfo = biy;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.ok(sb.length());
                    tbRichTextData.j(spannableString);
                    biq.add(0, tbRichTextData);
                }
            }
            this.llD = true;
        }
    }

    private com.baidu.tbadk.core.view.b e(boolean z, boolean z2, String str) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        bVar.hh(true);
        if (" 吧主".equals(str) || " 小吧主".equals(str) || " 楼主".equals(str) || " 品牌官".equals(str)) {
            bVar.lH(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
            bVar.wO(str);
            return bVar;
        }
        return bVar;
    }

    protected Drawable j(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36));
        return bitmapDrawable;
    }

    public int ddy() {
        return this.lkW;
    }

    public void fo(Context context) {
        int type;
        int i;
        int i2;
        if (this.lkU != null) {
            int i3 = -1;
            int size = this.lkV.size();
            if (size > 0) {
                try {
                    i3 = this.lkV.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.lkU.size()) {
                l lVar = this.lkU.get(i4);
                if (l.cV(i5, lVar.getType())) {
                    this.lkV.get(size - 1).b(lVar.fn(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.lkV.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.fn(context));
                        this.lkV.add(lVar2);
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

    public void fp(Context context) {
        try {
            if (this.lla != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.lla.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.lkV == null || this.lkV.size() == 0) {
                fo(context);
            }
            ArrayList<l> arrayList = this.lkV;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dde() != null) {
                            sb.append((CharSequence) next.dde());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String ya = TbFaceManager.bes().ya(next.getText());
                        if (ya != null) {
                            sb.append("[");
                            sb.append(ya);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !com.baidu.tbadk.core.util.aq.isEmpty(next.ddd())) {
                        sb.append("[").append(next.ddd()).append("]");
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
                this.lkS = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.fzt = com.baidu.tbadk.core.util.aq.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.llg = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.dFJ = metaData;
                }
                if (this.dFJ.getUserId() == null || this.dFJ.getUserId().length() <= 0 || this.dFJ.getUserId().equals("0")) {
                    this.dFJ = metaData2;
                }
                this.lla = TbRichTextView.a(context, subPostList.content, z);
                if (this.lla != null) {
                    this.lla.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
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
                this.lkS = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.fzt = com.baidu.tbadk.core.util.aq.getFormatTime(this.time);
                this.lkT = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.dFJ = metaData;
                }
                this.huD = post.need_log.intValue() == 1;
                this.llr = post.img_num_abtest.intValue() == 1;
                this.llj = new bg();
                this.llj.parserProtobuf(post.from_forum);
                if (this.dFJ.getUserId() == null || this.dFJ.getUserId().length() <= 0 || this.dFJ.getUserId().equals("0")) {
                    this.dFJ.parserProtobuf(post.author);
                }
                if (this.dFJ != null && context != null) {
                    this.lln = this.dFJ.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.llo = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.dFJ.getLevel_id()));
                }
                this.lld = post.is_ntitle.intValue() == 1;
                this.lkW = post.sub_post_number.intValue();
                this.lli = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.llI = post.is_wonderful_post.intValue() == 1;
                this.llE = post.is_top_agree_post.intValue() == 1;
                this.lla = TbRichTextView.a(context, list, true);
                if (this.lla != null) {
                    this.lla.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.lla.oj(this.lkS);
                    if (this.dFJ != null) {
                        this.lla.setAuthorId(this.dFJ.getUserId());
                    }
                    if ((this.llE || this.llI) && com.baidu.tbadk.a.d.aMo()) {
                        int i = this.llE ? com.baidu.adp.newwidget.ImageView.b.PI : com.baidu.adp.newwidget.ImageView.b.PJ;
                        Iterator<TbRichTextData> it = this.lla.biq().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            TbRichTextData next = it.next();
                            if (next != null && next.getType() == 1) {
                                next.k(com.baidu.tbadk.widget.richText.e.on(i));
                                break;
                            } else if (next != null && next.getType() == 8) {
                                next.ol(i);
                                break;
                            }
                        }
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.llg = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.uq(this.llC);
                            postData.a(subPostList, context);
                            this.lkX.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.llc.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.lle = new com.baidu.tbadk.data.c();
                    this.lle.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.llf = new com.baidu.tbadk.data.f();
                    this.llf.a(post.lbs_info);
                }
                this.dGr = post.storecount.intValue();
                this.llb.a(post.present);
                this.dFU.setUserMap(this.userMap);
                this.dFU.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.jZV = new SmallTailInfo();
                    this.jZV.id = post.signature.signature_id.intValue();
                    this.jZV.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.jZV.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.jZV.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.jZV.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.dGD.add(cVar);
                    }
                }
                this.dGG = post.skin_info;
                this.dGJ = post.lego_card;
                this.llp = post.tpoint_post;
                if (post.agree != null) {
                    this.llq = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.llq = false;
                }
                this.llx = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.dHm = new OriginalThreadInfo();
                    this.dHm.a(post.origin_thread_info);
                } else {
                    this.dHm = null;
                }
                this.llA = post.is_fold.intValue();
                this.jEA = post.fold_tip;
                this.llF = post.show_squared.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> llQ;
        private b llR;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.llQ = new SoftReference<>(context);
            this.llR = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.llQ != null && this.llQ.get() != null) {
                if (this.llR != null) {
                    this.llR.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.llQ.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fq(Context context) {
        ArrayList<TbRichTextData> biq;
        if (this.lla == null || (biq = this.lla.biq()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = biq.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bix().toString());
            } else if (next.getType() == 17) {
                String str = next.biB().mGifInfo.mSharpText;
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

    public String ddz() {
        ArrayList<TbRichTextData> biq;
        String str;
        if (this.lla == null || (biq = this.lla.biq()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = biq.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bix().toString());
                } else if (next.getType() == 17) {
                    if (next.biB() != null && next.biB().mGifInfo != null && (str = next.biB().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo ddA() {
        ArrayList<TbRichTextData> biq;
        if (this.lla != null && (biq = this.lla.biq()) != null) {
            Iterator<TbRichTextData> it = biq.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.biw().getWidth();
                    preLoadImageInfo.height = next.biw().getHeight();
                    preLoadImageInfo.imgUrl = next.biw().biJ();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.biC().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.biC().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.biC().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String ddB() {
        k ddb;
        PreLoadImageInfo ddA = ddA();
        if (ddA != null && !StringUtils.isNull(ddA.imgUrl)) {
            return ddA.imgUrl;
        }
        if (this.lli != null && (ddb = this.lli.ddb()) != null && !StringUtils.isNull(ddb.ddc())) {
            return ddb.ddc();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> biq;
        if (this.lla == null || (biq = this.lla.biq()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = biq.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.biw().getWidth();
                preLoadImageInfo.height = next.biw().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.biw().biO()) {
                    preLoadImageInfo.imgUrl = next.biw().biK();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.biw().biJ();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.biB() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.biB().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.biB().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.biB();
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
        if (this.dFJ == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.dFJ.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        if (this.lkR == 52) {
            return lkN;
        }
        if (this.lkR == 1) {
            return dGH;
        }
        if (this.lkR == 36) {
            return lkK;
        }
        if (this.lkR == 40 || this.lkR == 50) {
            return dEV;
        }
        if (this.lkR == 41) {
            return lkL;
        }
        if (this.lkR == 53) {
            return lkO;
        }
        if (ddu() == 1) {
            return lkI;
        }
        return lkJ;
    }

    public void setPostType(int i) {
        this.lkR = i;
    }

    public aq ddC() {
        return this.llb;
    }

    public void a(aq aqVar) {
        this.llb = aqVar;
    }

    public i ddD() {
        return this.lli;
    }

    public com.baidu.tbadk.widget.richText.i biA() {
        if (this.llm != null) {
            return this.llm;
        }
        if (this.lla != null && v.getCount(this.lla.biq()) > 0) {
            Iterator<TbRichTextData> it = this.lla.biq().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.llm = next.biA();
                    return this.llm;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo biy() {
        if (this.dXe != null) {
            return this.dXe;
        }
        if (this.lla != null && v.getCount(this.lla.biq()) > 0) {
            Iterator<TbRichTextData> it = this.lla.biq().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.dXe = next.biy();
                    return this.dXe;
                }
            }
        }
        return null;
    }

    public String ddE() {
        return this.lln;
    }

    public String aRI() {
        return this.dGJ;
    }

    public void aRK() {
        if (this.dGg == 0) {
            this.dGg = 1;
        }
    }

    public long aRX() {
        return this.agreeData.disAgreeNum;
    }

    public AgreeData aSp() {
        return this.agreeData;
    }

    public OriginalThreadInfo ddF() {
        return this.dHm;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.dHm = originalThreadInfo;
    }

    public int ddG() {
        return this.llA;
    }

    public String cCt() {
        return this.jEA;
    }

    public boolean ddH() {
        return this.llF;
    }
}
