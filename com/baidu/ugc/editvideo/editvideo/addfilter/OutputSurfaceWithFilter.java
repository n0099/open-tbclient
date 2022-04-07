package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.baidu.ugc.editvideo.magicmusic.effect.BaseEffect;
import com.repackage.w79;
import java.util.List;
/* loaded from: classes4.dex */
public class OutputSurfaceWithFilter extends BaseOutputSurface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isAr;
    public boolean isInitFu;
    public Context mContext;
    public FilterValue mFilterValue;
    public FullFrameRect mFullScreenFUDisplay;
    public boolean mIsAddWaterMark;
    public List<BaseEffect> mMagicEffectList;
    public Bitmap mWaterMarkBitmap;
    public int mWaterMarkTextureId;

    public OutputSurfaceWithFilter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsAddWaterMark = false;
        this.isAr = false;
        this.mContext = context;
    }

    public OutputSurfaceWithFilter(Context context, FilterValue filterValue, boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, filterValue, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsAddWaterMark = false;
        this.isAr = false;
        this.mIsAddWaterMark = z;
        this.mContext = context;
        if (filterValue != null) {
            this.mFilterValue = filterValue;
        }
        init(i, i2);
    }

    public OutputSurfaceWithFilter(Context context, FilterValue filterValue, boolean z, int i, int i2, boolean z2, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, filterValue, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2), handler};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mIsAddWaterMark = false;
        this.isAr = false;
        this.mIsAddWaterMark = z;
        this.mContext = context;
        if (filterValue != null) {
            this.mFilterValue = filterValue;
        }
        init(i, i2, z2, handler);
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void drawImage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.drawImage(i);
            if (!this.mIsAddWaterMark) {
                this.mFullScreenEXT.drawFrame(this.mTextureId, this.mSTMatrix);
                return;
            }
            if (this.mWaterMarkBitmap != null && this.mWaterMarkTextureId == 0) {
                this.mWaterMarkTextureId = this.mFullScreenFUDisplay.createTexture2DObject();
                GLUtils.texImage2D(3553, 0, this.mWaterMarkBitmap, 0);
            }
            this.mFullScreenEXT.drawFrame(this.mTextureId, this.mSTMatrix);
            int min = Math.min(this.mVideoWidth, this.mVideoHeight);
            int i2 = (min * 16) / 720;
            int i3 = (min * 112) / 720;
            GLES20.glViewport(i2, (this.mVideoHeight - i3) - i2, (min * 300) / 720, i3);
            GLES20.glDisable(2929);
            GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
            GLES20.glBlendFunc(1, 771);
            this.mFullScreenFUDisplay.setAngle(180.0f);
            this.mFullScreenFUDisplay.setScale(1.0f, -1.0f);
            this.mFullScreenFUDisplay.drawFrame(this.mWaterMarkTextureId, GlUtil.IDENTITY_MATRIX, true);
            GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
            GLES20.glViewport(0, 0, this.mVideoWidth, this.mVideoHeight);
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.release();
            FullFrameRect fullFrameRect = this.mFullScreenFUDisplay;
            if (fullFrameRect != null) {
                fullFrameRect.release(false);
                this.mFullScreenFUDisplay = null;
            }
        }
    }

    public void setAddWaterMark(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.mIsAddWaterMark = z;
        }
    }

    public void setFilterValue(FilterValue filterValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, filterValue) == null) {
            this.mFilterValue = filterValue;
        }
    }

    public void setMagicEffectList(List<BaseEffect> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.mMagicEffectList = list;
        }
    }

    public void setWaterMarkBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bitmap) == null) {
            this.mWaterMarkBitmap = bitmap;
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void setup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.setup();
            this.isAr = w79.c().i();
            this.mFullScreenFUDisplay = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        }
    }
}
