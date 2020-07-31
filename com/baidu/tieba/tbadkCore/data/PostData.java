package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements q, ag {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private List<HeadItem> dPQ;
    private SkinInfo dTC;
    private String dTF;
    private Item dUX;
    private OriginalThreadInfo dUi;
    private TbRichTextVoiceInfo ekK;
    private SmallTailInfo kDK;
    private String khR;
    public boolean lNB;
    private com.baidu.tbadk.widget.richText.j lNC;
    private String lND;
    private String lNE;
    private TPointPost lNF;
    public int lNI;
    public boolean lNL;
    public AlaLiveInfoCoreData lNO;
    private boolean lNS;
    public ap lNW;
    private String lNj;
    private ArrayList<PostData> lNn;
    private com.baidu.tbadk.data.c lNu;
    private com.baidu.tbadk.data.f lNv;
    private i lNy;
    private br lNz;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId lNa = BdUniqueId.gen();
    public static final BdUniqueId lNb = BdUniqueId.gen();
    public static final BdUniqueId dTD = BdUniqueId.gen();
    public static final BdUniqueId dRN = BdUniqueId.gen();
    public static final BdUniqueId dRS = BdUniqueId.gen();
    public static final BdUniqueId lNc = BdUniqueId.gen();
    public static final BdUniqueId lNd = BdUniqueId.gen();
    public static final BdUniqueId lNe = BdUniqueId.gen();
    public static final BdUniqueId lNf = BdUniqueId.gen();
    public static final BdUniqueId lNg = BdUniqueId.gen();
    public static boolean lNh = false;
    private int lNi = 0;
    private boolean lNo = false;
    private ArrayList<PostData> lNp = null;
    private TbRichText lNq = null;
    private boolean lNt = false;
    private boolean lNw = false;
    private boolean lNx = false;
    public boolean lNA = false;
    public int dTc = 0;
    private boolean lNG = false;
    public boolean hND = false;
    public boolean lNH = false;
    public boolean lNJ = false;
    public boolean lNK = true;
    public boolean lNM = false;
    public boolean lNN = false;
    private boolean lNP = false;
    private int lNQ = 0;
    private boolean lNR = true;
    public boolean lNT = false;
    public boolean lNU = false;
    public boolean lNV = false;
    public boolean lNX = false;
    public boolean lNY = false;
    private b lNZ = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.lNW != null) {
                ap baN = PostData.this.lNW.baN();
                baN.delete("obj_locate");
                baN.ah("obj_locate", 7);
                TiebaStatic.log(baN);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData dSF = new MetaData();
    private ArrayList<l> lNk = new ArrayList<>();
    private ArrayList<l> lNl = new ArrayList<>();
    private int lNm = 0;
    private int dTn = 0;
    private PraiseData dSQ = new PraiseData();
    private aw lNr = new aw();
    private c lNs = new c();
    private ArrayList<com.baidu.tbadk.data.c> dTz = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.lNn = null;
        this.lNI = 0;
        this.lNn = new ArrayList<>();
        this.lNI = 0;
    }

    public void vj(boolean z) {
        this.lNS = z;
    }

    public boolean dkZ() {
        return this.lNS;
    }

    public ArrayList<PostData> dla() {
        return this.lNp;
    }

    public void dlb() {
        this.lNp.clear();
        this.lNp = null;
        this.lNo = false;
    }

    public void w(PostData postData) {
        if (postData != null) {
            if (this.lNp == null) {
                this.lNp = new ArrayList<>();
                if (x.getCount(this.lNn) > 2) {
                    this.lNp.addAll(x.subList(this.lNn, 0, 2));
                } else {
                    this.lNp.addAll(this.lNn);
                }
            }
            this.lNp.add(postData);
        }
    }

    public void x(PostData postData) {
        if (postData != null && this.lNn != null) {
            this.lNn.add(postData);
            dlf();
        }
    }

    public void NN(String str) {
        if (this.lNp != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.lNp.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.lNp.remove(next);
                    return;
                }
            }
        }
    }

    public void vk(boolean z) {
        this.lNR = z;
    }

    public boolean dlc() {
        return this.lNR;
    }

    public void vl(boolean z) {
        this.lNo = z;
    }

    public boolean dld() {
        return this.lNo;
    }

    public ArrayList<PostData> dle() {
        return this.lNn;
    }

    public void dlf() {
        this.lNm++;
    }

    public void dlg() {
        this.lNm--;
    }

    public void Fr(int i) {
        this.lNm = i;
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

    public int dlh() {
        return this.floor_num;
    }

    public void Fs(int i) {
        this.floor_num = i;
    }

    public boolean dli() {
        return this.lNx;
    }

    public void vm(boolean z) {
        this.lNx = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = as.getFormatTime(j);
    }

    public MetaData aWl() {
        return this.dSF;
    }

    public void a(MetaData metaData) {
        this.dSF = metaData;
    }

    public void a(PraiseData praiseData) {
        this.dSQ = praiseData;
    }

    public TbRichText dlj() {
        return this.lNq;
    }

    public void c(TbRichText tbRichText) {
        this.lNq = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo cSs() {
        return this.kDK;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.kDK = smallTailInfo;
    }

    public com.baidu.tbadk.data.f dlk() {
        return this.lNv;
    }

    public SkinInfo aWH() {
        return this.dTC;
    }

    public void vn(boolean z) {
        this.lNP = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.lNq != null && this.lNq.boJ() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.dSF != null && this.dSF.getIs_bawu() == 1) {
                    if (this.lNS) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.dSF.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.dSF.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.dSF.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.dSF.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = aWl().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.ln().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.ln().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.lNq.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.j(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.dSF.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.dSF.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.dSF == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.dSF.getName_show() + str + "：");
                str2 = this.dSF.getUserName();
                str3 = this.dSF.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.dSF.getSealPrefix())) {
                Bitmap bitmap = ao.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.dSF.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.lNZ), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.dSF != null && this.dSF.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b e = e(z, this.dSF != null && this.dSF.getIs_bawu() == 1, str);
                if (e != null) {
                    if (this.dSF != null) {
                        int i3 = 0;
                        if (this.dSF.getName_show() != null) {
                            i3 = this.dSF.getName_show().length();
                        }
                        spannableString.setSpan(e, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> boJ = this.lNq.boJ();
            if (boJ != null && boJ.size() > 0) {
                TbRichTextData tbRichTextData2 = boJ.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.boQ() != null) {
                    if (this.lNP) {
                        int indexOf = tbRichTextData2.boQ().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.boQ().delete(0, indexOf + 1);
                        }
                        this.lNP = false;
                    }
                    tbRichTextData2.pd(sb.length());
                    tbRichTextData2.boQ().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= boJ.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (boJ.get(i5) == null || boJ.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo boR = boJ.get(i5).boR();
                            boJ.remove(i5);
                            tbRichTextVoiceInfo = boR;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.pd(sb.length());
                    tbRichTextData.n(spannableString);
                    boJ.add(0, tbRichTextData);
                }
            }
            this.lNT = true;
        }
    }

    private com.baidu.tbadk.core.view.b e(boolean z, boolean z2, String str) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        bVar.hV(true);
        if (" 吧主".equals(str) || " 小吧主".equals(str) || " 楼主".equals(str) || " 品牌官".equals(str)) {
            bVar.mt(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
            bVar.yk(str);
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
        bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
        return bitmapDrawable;
    }

    public int dll() {
        return this.lNm;
    }

    public void fr(Context context) {
        int type;
        int i;
        int i2;
        if (this.lNk != null) {
            int i3 = -1;
            int size = this.lNl.size();
            if (size > 0) {
                try {
                    i3 = this.lNl.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.lNk.size()) {
                l lVar = this.lNk.get(i4);
                if (l.dd(i5, lVar.getType())) {
                    this.lNl.get(size - 1).b(lVar.fq(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.lNl.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.fq(context));
                        this.lNl.add(lVar2);
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

    public void fs(Context context) {
        try {
            if (this.lNq != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.lNq.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.lNl == null || this.lNl.size() == 0) {
                fr(context);
            }
            ArrayList<l> arrayList = this.lNl;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dkR() != null) {
                            sb.append((CharSequence) next.dkR());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String zz = TbFaceManager.bkj().zz(next.getText());
                        if (zz != null) {
                            sb.append("[");
                            sb.append(zz);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !as.isEmpty(next.dkQ())) {
                        sb.append("[").append(next.dkQ()).append("]");
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
                this.date = as.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.lNw = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.dSF = metaData;
                }
                if (this.dSF.getUserId() == null || this.dSF.getUserId().length() <= 0 || this.dSF.getUserId().equals("0")) {
                    this.dSF = metaData2;
                }
                this.lNq = TbRichTextView.a(context, subPostList.content, z);
                if (this.lNq != null) {
                    this.lNq.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        TbRichTextData tbRichTextData;
        int i;
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = as.getFormatTime(this.time);
                this.lNj = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.dSF = metaData;
                }
                this.hND = post.need_log.intValue() == 1;
                this.lNH = post.img_num_abtest.intValue() == 1;
                this.lNz = new br();
                this.lNz.parserProtobuf(post.from_forum);
                if (this.dSF.getUserId() == null || this.dSF.getUserId().length() <= 0 || this.dSF.getUserId().equals("0")) {
                    this.dSF.parserProtobuf(post.author);
                }
                if (this.dSF != null && context != null) {
                    this.lND = this.dSF.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.lNE = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.dSF.getLevel_id()));
                }
                this.lNt = post.is_ntitle.intValue() == 1;
                this.lNm = post.sub_post_number.intValue();
                this.lNy = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.lNX = post.is_wonderful_post.intValue() == 1;
                this.lNU = post.is_top_agree_post.intValue() == 1;
                this.dPQ = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.dUX = post.item;
                }
                this.lNq = TbRichTextView.a(context, list, true);
                if (this.lNq != null) {
                    this.lNq.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.lNq.pc(this.floor_num);
                    if (this.dSF != null) {
                        this.lNq.setAuthorId(this.dSF.getUserId());
                    }
                    int count = x.getCount(this.dPQ);
                    if (this.floor_num == 1 && count != 0 && this.dPQ != null) {
                        ArrayList<TbRichTextData> boJ = this.lNq.boJ();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) x.getItem(boJ, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                x.add(boJ, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) x.getItem(this.dPQ, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.o(com.baidu.tbadk.widget.richText.e.F(i, false));
                            }
                        } else {
                            for (int size = this.dPQ.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.dPQ.get(size);
                                if (headItem2 != null) {
                                    a(boJ, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.dUX != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.dUX));
                        x.add(this.lNq.boJ(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.lNw = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.vj(this.lNS);
                            postData.a(subPostList, context);
                            this.lNn.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.lNs.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.lNu = new com.baidu.tbadk.data.c();
                    this.lNu.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.lNv = new com.baidu.tbadk.data.f();
                    this.lNv.a(post.lbs_info);
                }
                this.dTn = post.storecount.intValue();
                this.lNr.a(post.present);
                this.dSQ.setUserMap(this.userMap);
                this.dSQ.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.kDK = new SmallTailInfo();
                    this.kDK.id = post.signature.signature_id.intValue();
                    this.kDK.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.kDK.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.kDK.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.kDK.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.dTz.add(cVar);
                    }
                }
                this.dTC = post.skin_info;
                this.dTF = post.lego_card;
                this.lNF = post.tpoint_post;
                if (post.agree != null) {
                    this.lNG = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.lNG = false;
                }
                this.lNN = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.dUi = new OriginalThreadInfo();
                    this.dUi.a(post.origin_thread_info);
                } else {
                    this.dUi = null;
                }
                this.lNQ = post.is_fold.intValue();
                this.khR = post.fold_tip;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(headItem.name + ": " + (headItem.type.intValue() == 1 ? headItem.content : " ")));
        if (headItem.type.intValue() == 2) {
            try {
                i = Integer.parseInt(headItem.content);
            } catch (NumberFormatException e) {
                i = 0;
            }
            spannableStringBuilder.append((CharSequence) com.baidu.tbadk.widget.richText.e.F(i, true));
        }
        tbRichTextData.n(spannableStringBuilder);
        x.add(list, 0, tbRichTextData);
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ao.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> lOf;
        private b lOg;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.lOf = new SoftReference<>(context);
            this.lOg = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ao.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.lOf != null && this.lOf.get() != null) {
                if (this.lOg != null) {
                    this.lOg.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.lOf.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String ft(Context context) {
        ArrayList<TbRichTextData> boJ;
        if (this.lNq == null || (boJ = this.lNq.boJ()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = boJ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.boQ().toString());
            } else if (next.getType() == 17) {
                String str = next.boU().mGifInfo.mSharpText;
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

    public String dlm() {
        ArrayList<TbRichTextData> boJ;
        String str;
        if (this.lNq == null || (boJ = this.lNq.boJ()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = boJ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.boQ().toString());
                } else if (next.getType() == 17) {
                    if (next.boU() != null && next.boU().mGifInfo != null && (str = next.boU().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dln() {
        ArrayList<TbRichTextData> boJ;
        if (this.lNq != null && (boJ = this.lNq.boJ()) != null) {
            Iterator<TbRichTextData> it = boJ.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.boP().getWidth();
                    preLoadImageInfo.height = next.boP().getHeight();
                    preLoadImageInfo.imgUrl = next.boP().bpe();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.boV().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.boV().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.boV().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dlo() {
        k dkO;
        PreLoadImageInfo dln = dln();
        if (dln != null && !StringUtils.isNull(dln.imgUrl)) {
            return dln.imgUrl;
        }
        if (this.lNy != null && (dkO = this.lNy.dkO()) != null && !StringUtils.isNull(dkO.dkP())) {
            return dkO.dkP();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ag
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> boJ;
        if (this.lNq == null || (boJ = this.lNq.boJ()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = boJ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.boP().getWidth();
                preLoadImageInfo.height = next.boP().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.boP().bpj()) {
                    preLoadImageInfo.imgUrl = next.boP().bpf();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.boP().bpe();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.boU() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.boU().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.boU().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.boU();
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
        if (this.dSF == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.dSF.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.lNi == 52) {
            return lNe;
        }
        if (this.lNi == 1) {
            return dTD;
        }
        if (this.lNi == 36) {
            return dRN;
        }
        if (this.lNi == 40 || this.lNi == 50) {
            return dRS;
        }
        if (this.lNi == 41) {
            return lNc;
        }
        if (this.lNi == 53) {
            return lNf;
        }
        if (dlh() == 1) {
            return lNa;
        }
        return lNb;
    }

    public void setPostType(int i) {
        this.lNi = i;
    }

    public aw dlp() {
        return this.lNr;
    }

    public void a(aw awVar) {
        this.lNr = awVar;
    }

    public i dlq() {
        return this.lNy;
    }

    public com.baidu.tbadk.widget.richText.j boT() {
        if (this.lNC != null) {
            return this.lNC;
        }
        if (this.lNq != null && x.getCount(this.lNq.boJ()) > 0) {
            Iterator<TbRichTextData> it = this.lNq.boJ().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.lNC = next.boT();
                    return this.lNC;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo boR() {
        if (this.ekK != null) {
            return this.ekK;
        }
        if (this.lNq != null && x.getCount(this.lNq.boJ()) > 0) {
            Iterator<TbRichTextData> it = this.lNq.boJ().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.ekK = next.boR();
                    return this.ekK;
                }
            }
        }
        return null;
    }

    public String dlr() {
        return this.lND;
    }

    public String aXv() {
        return this.dTF;
    }

    public void aXx() {
        if (this.dTc == 0) {
            this.dTc = 1;
        }
    }

    public long aXK() {
        return this.agreeData.disAgreeNum;
    }

    public int aXM() {
        return this.agreeData.agreeType;
    }

    public AgreeData aYc() {
        return this.agreeData;
    }

    public OriginalThreadInfo dls() {
        return this.dUi;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.dUi = originalThreadInfo;
    }

    public int dlt() {
        return this.lNQ;
    }

    public String cKI() {
        return this.khR;
    }
}
