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
    private String jFG;
    private SmallTailInfo kbc;
    public int lmB;
    public boolean lmE;
    public AlaLiveInfoCoreData lmH;
    private boolean lmL;
    private boolean lmO;
    public an lmQ;
    private String lmc;
    private ArrayList<PostData> lmg;
    private com.baidu.tbadk.data.c lmn;
    private com.baidu.tbadk.data.f lmo;
    private i lmr;
    private bg lms;
    public boolean lmu;
    private com.baidu.tbadk.widget.richText.i lmv;
    private String lmw;
    private String lmx;
    private TPointPost lmy;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId llR = BdUniqueId.gen();
    public static final BdUniqueId llS = BdUniqueId.gen();
    public static final BdUniqueId dGH = BdUniqueId.gen();
    public static final BdUniqueId llT = BdUniqueId.gen();
    public static final BdUniqueId dEV = BdUniqueId.gen();
    public static final BdUniqueId llU = BdUniqueId.gen();
    public static final BdUniqueId llV = BdUniqueId.gen();
    public static final BdUniqueId llW = BdUniqueId.gen();
    public static final BdUniqueId llX = BdUniqueId.gen();
    public static final BdUniqueId llY = BdUniqueId.gen();
    public static boolean llZ = false;
    private int lma = 0;
    private boolean lmh = false;
    private ArrayList<PostData> lmi = null;
    private TbRichText lmj = null;
    private boolean lmm = false;
    private boolean lmp = false;
    private boolean lmq = false;
    public boolean lmt = false;
    public int dGg = 0;
    private boolean lmz = false;
    public boolean huO = false;
    public boolean lmA = false;
    public boolean lmC = false;
    public boolean lmD = true;
    public boolean lmF = false;
    public boolean lmG = false;
    private boolean lmI = false;
    private int lmJ = 0;
    private boolean lmK = true;
    public boolean lmM = false;
    public boolean lmN = false;
    public boolean lmP = false;
    public boolean lmR = false;
    public boolean lmS = false;
    private b lmT = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.lmQ != null) {
                an aUS = PostData.this.lmQ.aUS();
                aUS.delete("obj_locate");
                aUS.ag("obj_locate", 7);
                TiebaStatic.log(aUS);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int lmb = 0;
    private long time = 0;
    private String fzE = null;
    private MetaData dFJ = new MetaData();
    private ArrayList<l> lmd = new ArrayList<>();
    private ArrayList<l> lme = new ArrayList<>();
    private int lmf = 0;
    private int dGr = 0;
    private PraiseData dFU = new PraiseData();
    private aq lmk = new aq();
    private c lml = new c();
    private ArrayList<com.baidu.tbadk.data.c> dGD = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.lmg = null;
        this.lmB = 0;
        this.lmg = new ArrayList<>();
        this.lmB = 0;
    }

    public void uq(boolean z) {
        this.lmL = z;
    }

    public boolean ddB() {
        return this.lmL;
    }

    public ArrayList<PostData> ddC() {
        return this.lmi;
    }

    public void ddD() {
        this.lmi.clear();
        this.lmi = null;
        this.lmh = false;
    }

    public void w(PostData postData) {
        if (postData != null) {
            if (this.lmi == null) {
                this.lmi = new ArrayList<>();
                if (v.getCount(this.lmg) > 2) {
                    this.lmi.addAll(v.subList(this.lmg, 0, 2));
                } else {
                    this.lmi.addAll(this.lmg);
                }
            }
            this.lmi.add(postData);
        }
    }

    public void x(PostData postData) {
        if (postData != null && this.lmg != null) {
            this.lmg.add(postData);
            ddH();
        }
    }

    public void MC(String str) {
        if (this.lmi != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.lmi.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.lmi.remove(next);
                    return;
                }
            }
        }
    }

    public void ur(boolean z) {
        this.lmK = z;
    }

    public boolean ddE() {
        return this.lmK;
    }

    public void us(boolean z) {
        this.lmh = z;
    }

    public boolean ddF() {
        return this.lmh;
    }

    public ArrayList<PostData> ddG() {
        return this.lmg;
    }

    public void ddH() {
        this.lmf++;
    }

    public void ddI() {
        this.lmf--;
    }

    public void DT(int i) {
        this.lmf = i;
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

    public int ddJ() {
        return this.lmb;
    }

    public void DU(int i) {
        this.lmb = i;
    }

    public boolean ddK() {
        return this.lmq;
    }

    public void ut(boolean z) {
        this.lmq = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.fzE = com.baidu.tbadk.core.util.aq.getFormatTime(j);
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

    public TbRichText ddL() {
        return this.lmj;
    }

    public void c(TbRichText tbRichText) {
        this.lmj = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo cKn() {
        return this.kbc;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.kbc = smallTailInfo;
    }

    public com.baidu.tbadk.data.f ddM() {
        return this.lmo;
    }

    public SkinInfo aQU() {
        return this.dGG;
    }

    public void uu(boolean z) {
        this.lmI = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.lmj != null && this.lmj.bis() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.dFJ != null && this.dFJ.getIs_bawu() == 1) {
                    if (this.lmL) {
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
                                            PostData.this.lmj.isChanged = true;
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
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.lmT), 0, spannableString.length(), 18);
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
            ArrayList<TbRichTextData> bis = this.lmj.bis();
            if (bis != null && bis.size() > 0) {
                TbRichTextData tbRichTextData2 = bis.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.biz() != null) {
                    if (this.lmI) {
                        int indexOf = tbRichTextData2.biz().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.biz().delete(0, indexOf + 1);
                        }
                        this.lmI = false;
                    }
                    tbRichTextData2.om(sb.length());
                    tbRichTextData2.biz().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bis.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bis.get(i5) == null || bis.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo biA = bis.get(i5).biA();
                            bis.remove(i5);
                            tbRichTextVoiceInfo = biA;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.om(sb.length());
                    tbRichTextData.j(spannableString);
                    bis.add(0, tbRichTextData);
                }
            }
            this.lmM = true;
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
            bVar.lJ(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
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

    public int ddN() {
        return this.lmf;
    }

    public void fo(Context context) {
        int type;
        int i;
        int i2;
        if (this.lmd != null) {
            int i3 = -1;
            int size = this.lme.size();
            if (size > 0) {
                try {
                    i3 = this.lme.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.lmd.size()) {
                l lVar = this.lmd.get(i4);
                if (l.cV(i5, lVar.getType())) {
                    this.lme.get(size - 1).b(lVar.fn(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.lme.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.fn(context));
                        this.lme.add(lVar2);
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
            if (this.lmj != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.lmj.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.lme == null || this.lme.size() == 0) {
                fo(context);
            }
            ArrayList<l> arrayList = this.lme;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.ddt() != null) {
                            sb.append((CharSequence) next.ddt());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String ya = TbFaceManager.bet().ya(next.getText());
                        if (ya != null) {
                            sb.append("[");
                            sb.append(ya);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !com.baidu.tbadk.core.util.aq.isEmpty(next.dds())) {
                        sb.append("[").append(next.dds()).append("]");
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
                this.lmb = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.fzE = com.baidu.tbadk.core.util.aq.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.lmp = subPostList.is_giftpost.intValue() == 1;
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
                this.lmj = TbRichTextView.a(context, subPostList.content, z);
                if (this.lmj != null) {
                    this.lmj.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
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
                this.lmb = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.fzE = com.baidu.tbadk.core.util.aq.getFormatTime(this.time);
                this.lmc = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.dFJ = metaData;
                }
                this.huO = post.need_log.intValue() == 1;
                this.lmA = post.img_num_abtest.intValue() == 1;
                this.lms = new bg();
                this.lms.parserProtobuf(post.from_forum);
                if (this.dFJ.getUserId() == null || this.dFJ.getUserId().length() <= 0 || this.dFJ.getUserId().equals("0")) {
                    this.dFJ.parserProtobuf(post.author);
                }
                if (this.dFJ != null && context != null) {
                    this.lmw = this.dFJ.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.lmx = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.dFJ.getLevel_id()));
                }
                this.lmm = post.is_ntitle.intValue() == 1;
                this.lmf = post.sub_post_number.intValue();
                this.lmr = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.lmR = post.is_wonderful_post.intValue() == 1;
                this.lmN = post.is_top_agree_post.intValue() == 1;
                this.lmj = TbRichTextView.a(context, list, true);
                if (this.lmj != null) {
                    this.lmj.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.lmj.ol(this.lmb);
                    if (this.dFJ != null) {
                        this.lmj.setAuthorId(this.dFJ.getUserId());
                    }
                    if ((this.lmN || this.lmR) && com.baidu.tbadk.a.d.aMo()) {
                        int i = this.lmN ? com.baidu.adp.newwidget.ImageView.b.PI : com.baidu.adp.newwidget.ImageView.b.PJ;
                        Iterator<TbRichTextData> it = this.lmj.bis().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            TbRichTextData next = it.next();
                            if (next != null && next.getType() == 1) {
                                next.k(com.baidu.tbadk.widget.richText.e.op(i));
                                break;
                            } else if (next != null && next.getType() == 8) {
                                next.on(i);
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
                            postData.lmp = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.uq(this.lmL);
                            postData.a(subPostList, context);
                            this.lmg.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.lml.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.lmn = new com.baidu.tbadk.data.c();
                    this.lmn.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.lmo = new com.baidu.tbadk.data.f();
                    this.lmo.a(post.lbs_info);
                }
                this.dGr = post.storecount.intValue();
                this.lmk.a(post.present);
                this.dFU.setUserMap(this.userMap);
                this.dFU.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.kbc = new SmallTailInfo();
                    this.kbc.id = post.signature.signature_id.intValue();
                    this.kbc.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.kbc.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.kbc.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.kbc.updateShowInfo();
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
                this.lmy = post.tpoint_post;
                if (post.agree != null) {
                    this.lmz = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.lmz = false;
                }
                this.lmG = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.dHm = new OriginalThreadInfo();
                    this.dHm.a(post.origin_thread_info);
                } else {
                    this.dHm = null;
                }
                this.lmJ = post.is_fold.intValue();
                this.jFG = post.fold_tip;
                this.lmO = post.show_squared.intValue() == 1;
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
        private SoftReference<Context> lmZ;
        private b lna;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.lmZ = new SoftReference<>(context);
            this.lna = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.lmZ != null && this.lmZ.get() != null) {
                if (this.lna != null) {
                    this.lna.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.lmZ.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fq(Context context) {
        ArrayList<TbRichTextData> bis;
        if (this.lmj == null || (bis = this.lmj.bis()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bis.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.biz().toString());
            } else if (next.getType() == 17) {
                String str = next.biD().mGifInfo.mSharpText;
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

    public String ddO() {
        ArrayList<TbRichTextData> bis;
        String str;
        if (this.lmj == null || (bis = this.lmj.bis()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bis.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.biz().toString());
                } else if (next.getType() == 17) {
                    if (next.biD() != null && next.biD().mGifInfo != null && (str = next.biD().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo ddP() {
        ArrayList<TbRichTextData> bis;
        if (this.lmj != null && (bis = this.lmj.bis()) != null) {
            Iterator<TbRichTextData> it = bis.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.biy().getWidth();
                    preLoadImageInfo.height = next.biy().getHeight();
                    preLoadImageInfo.imgUrl = next.biy().biL();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.biE().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.biE().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.biE().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String ddQ() {
        k ddq;
        PreLoadImageInfo ddP = ddP();
        if (ddP != null && !StringUtils.isNull(ddP.imgUrl)) {
            return ddP.imgUrl;
        }
        if (this.lmr != null && (ddq = this.lmr.ddq()) != null && !StringUtils.isNull(ddq.ddr())) {
            return ddq.ddr();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bis;
        if (this.lmj == null || (bis = this.lmj.bis()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bis.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.biy().getWidth();
                preLoadImageInfo.height = next.biy().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.biy().biQ()) {
                    preLoadImageInfo.imgUrl = next.biy().biM();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.biy().biL();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.biD() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.biD().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.biD().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.biD();
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
        if (this.lma == 52) {
            return llW;
        }
        if (this.lma == 1) {
            return dGH;
        }
        if (this.lma == 36) {
            return llT;
        }
        if (this.lma == 40 || this.lma == 50) {
            return dEV;
        }
        if (this.lma == 41) {
            return llU;
        }
        if (this.lma == 53) {
            return llX;
        }
        if (ddJ() == 1) {
            return llR;
        }
        return llS;
    }

    public void setPostType(int i) {
        this.lma = i;
    }

    public aq ddR() {
        return this.lmk;
    }

    public void a(aq aqVar) {
        this.lmk = aqVar;
    }

    public i ddS() {
        return this.lmr;
    }

    public com.baidu.tbadk.widget.richText.i biC() {
        if (this.lmv != null) {
            return this.lmv;
        }
        if (this.lmj != null && v.getCount(this.lmj.bis()) > 0) {
            Iterator<TbRichTextData> it = this.lmj.bis().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.lmv = next.biC();
                    return this.lmv;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo biA() {
        if (this.dXe != null) {
            return this.dXe;
        }
        if (this.lmj != null && v.getCount(this.lmj.bis()) > 0) {
            Iterator<TbRichTextData> it = this.lmj.bis().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.dXe = next.biA();
                    return this.dXe;
                }
            }
        }
        return null;
    }

    public String ddT() {
        return this.lmw;
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

    public OriginalThreadInfo ddU() {
        return this.dHm;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.dHm = originalThreadInfo;
    }

    public int ddV() {
        return this.lmJ;
    }

    public String cCJ() {
        return this.jFG;
    }

    public boolean ddW() {
        return this.lmO;
    }
}
